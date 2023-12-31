package my.utm.ip.demo.mvc.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.utm.ip.demo.mvc.app.ServiceLocator;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		ServiceLocator.loadServices();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceLocator.initServices(req, resp);
		super.service(req, resp);
	}
}
