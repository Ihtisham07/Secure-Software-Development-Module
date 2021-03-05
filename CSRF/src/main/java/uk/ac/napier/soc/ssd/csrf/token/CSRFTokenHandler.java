/**
 * Credit to Dominik Schadow. The code used in this application has been adapted from https://github.com/dschadow/Java-Web-Security.
 */
package uk.ac.napier.soc.ssd.csrf.token;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public final class CSRFTokenHandler {
	public static final String CSRF_TOKEN = "CSRF_TOKEN";
	private static final String MISSING_SESSION = "No session available";

	/**
	 * Private constructor to prevent initialization.
	 */
	private CSRFTokenHandler() {
	}

	private static String getToken() throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
		sr.nextBytes(new byte[20]);
		return String.valueOf(sr.nextLong());
	}

	public static String getToken(HttpSession session)
			throws ServletException, NoSuchAlgorithmException, NoSuchProviderException {
		if (session == null) {
			throw new ServletException(MISSING_SESSION);
		}

		String token = (String) session.getAttribute(CSRF_TOKEN);

		if (StringUtils.isEmpty(token)) {
			token = getToken();
			session.setAttribute(CSRF_TOKEN, token);
		}

		return token;
	}

	public static boolean isValid(HttpServletRequest request)
			throws ServletException, NoSuchAlgorithmException, NoSuchProviderException {
		if (request.getSession(false) == null) {
			throw new ServletException(MISSING_SESSION);
		}

		System.out.println(request.getParameter(CSRF_TOKEN));
		System.out.println(getToken(request.getSession(false)));
		
		return StringUtils.equals(getToken(request.getSession(false)), request.getParameter(CSRF_TOKEN));
	}
}