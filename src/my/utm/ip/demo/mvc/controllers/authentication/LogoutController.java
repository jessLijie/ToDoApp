package my.utm.ip.demo.mvc.controllers.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.utm.ip.demo.mvc.app.ServiceLocator;
import my.utm.ip.demo.mvc.controllers.Controller;
import my.utm.ip.demo.mvc.services.authentication.AuthenticationService;
import my.utm.ip.demo.mvc.services.session.SessionService;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends Controller {
	private static final long serialVersionUID = 1L;
	private SessionService session;
	private AuthenticationService auth;

	@Override
	public void init() throws ServletException {
		super.init();
		auth = (AuthenticationService) ServiceLocator.getService("AUTHENTICATION_SERVICE");
		session = (SessionService) ServiceLocator.getService("SESSION_SERVICE");
	}


	public LogoutController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		auth.logout();
		session.delete("user");
		response.sendRedirect("login/login.jsp");
	}

}
