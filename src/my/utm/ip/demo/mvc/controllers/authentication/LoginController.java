package my.utm.ip.demo.mvc.controllers.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.utm.ip.demo.mvc.app.ServiceLocator;
import my.utm.ip.demo.mvc.controllers.Controller;
import my.utm.ip.demo.mvc.models.User;
import my.utm.ip.demo.mvc.services.authentication.AuthenticationService;
import my.utm.ip.demo.mvc.services.session.SessionService;
import my.utm.ip.demo.mvc.app.*;
@WebServlet("/login")
public class LoginController extends Controller {

	private static final long serialVersionUID = 1L;
	private AuthenticationService auth;
	private SessionService session;

	@Override
	public void init() throws ServletException {
		super.init();
		auth = (AuthenticationService) ServiceLocator.getService("AUTHENTICATION_SERVICE");
		session = (SessionService) ServiceLocator.getService("SESSION_SERVICE");
	}

	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		// steps:
		// 1. Read inputs sent by the client
		// 2. perform credential checking
		// 3. If the user's credential match, establish a session for it
		// 4. forward execution to view

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = auth.login(username, password);
		if (user != null) {
			user.setAuthenticated(true);
			session.set("user", user);
			response.sendRedirect("/" + Configs.APP + "/toDoList");
		} else {
			response.sendRedirect("/" + Configs.APP + "/login/login_error.jsp");
		}

	}

}
