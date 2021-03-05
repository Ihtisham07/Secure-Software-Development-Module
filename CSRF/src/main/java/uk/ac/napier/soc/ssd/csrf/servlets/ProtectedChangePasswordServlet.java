/**
 * Credit to Dominik Schadow. The code used in this application has been adapted from https://github.com/dschadow/Java-Web-Security.
 */
package uk.ac.napier.soc.ssd.csrf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.napier.soc.ssd.csrf.token.CSRFTokenHandler;

@WebServlet(name = "ProtectedChangePasswordServlet", urlPatterns = {"/ProtectedChangePasswordServlet"})
public class ProtectedChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProtectedChangePasswordServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        LOGGER.info("Processing protected GET request");

        response.setContentType("text/html");

        try {
            if (!CSRFTokenHandler.isValid(request)) {
                LOGGER.warn("CSRF token is invalid");
                response.setStatus(401);

                try (PrintWriter out = response.getWriter()) {
                    out.println("CSRF token is invalid");
                } catch (IOException ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }

                return;
            }
        } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        LOGGER.info("CSRF token is valid");

        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        LOGGER.info("Received {} and {} as GET parameter.", newPassword, confirmPassword);

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CSRF - Protected Servlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/styles.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>CSRF - Protected Servlet</h1>");
            out.println("<p>Received <b>" + newPassword + "</b> and <b>" + confirmPassword + "</b> as GET parameter.</p>");
            out.println("<p><a href=\"requests-protected.html\">Back</a></p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        LOGGER.info("Processing protected POST request");

        response.setContentType("text/html");

        try {
            if (!CSRFTokenHandler.isValid(request)) {
                LOGGER.warn("CSRF token is invalid");
                response.setStatus(401);
                return;
            }
        } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        LOGGER.info("CSRF token is valid");

        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        LOGGER.info("Received {} and {} as POST parameter.", newPassword, confirmPassword);

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Chapter 08 - CSRF</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/styles.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Chapter 08 - CSRF</h1>");
            out.println("<p>Received <b>" + newPassword + "</b> and <b>" + confirmPassword + "</b> as POST parameter.</p>");
            out.println("<p><a href=\"requests-protected.html\">Back</a></p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }
}
