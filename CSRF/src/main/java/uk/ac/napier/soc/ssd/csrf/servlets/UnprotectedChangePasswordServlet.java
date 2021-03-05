/**
 * Credit to Dominik Schadow. The code used in this application has been adapted from https://github.com/dschadow/Java-Web-Security.
 */
package uk.ac.napier.soc.ssd.csrf.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "UnprotectedChangePasswordServlet", urlPatterns = {"/UnprotectedChangePasswordServlet"})
public class UnprotectedChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(UnprotectedChangePasswordServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        LOGGER.info("Processing unprotected GET request: Received {} and {} as parameter.", newPassword, confirmPassword);

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CSRF</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/styles.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>CSRF</h1>");
            out.println("<p>Received <b>" + newPassword + "</b> and <b>" + confirmPassword + "</b> as GET parameter.</p>");
            out.println("<p><a href=\"requests-unprotected.html\">Back</a></p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        LOGGER.info("Processing unprotected POST request: Received {} and {} as parameter.", newPassword, confirmPassword);

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CSRF - Unprotected Servlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/styles.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>CSRF - Unprotected Servlet</h1>");
            out.println("<p>Received <b>" + newPassword + "</b> and <b>" + confirmPassword + "</b> as POST parameter.</p>");
            out.println("<p><a href=\"requests-unprotected.html\">Back</a></p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }
}
