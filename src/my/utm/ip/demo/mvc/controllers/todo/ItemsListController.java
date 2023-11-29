package my.utm.ip.demo.mvc.controllers.todo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.utm.ip.demo.mvc.app.Configs;
import my.utm.ip.demo.mvc.services.MockDatabase;
import my.utm.ip.demo.mvc.services.todo.MockItemsService;
import my.utm.ip.demo.mvc.models.ToDoItems;
import my.utm.ip.demo.mvc.models.User;

@WebServlet("/toDoList")
public class ItemsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		// Check if the user is authenticated
		User user = (User) request.getSession().getAttribute("user");

		if (user == null || !user.getAuthenticated()) {
			// Redirect to the login page if the user is not authenticated
			response.sendRedirect("/" + Configs.APP + "/login/login.jsp");
			return;
		}

		session.setAttribute("toDoItems", MockDatabase.toDoItems);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/todo/toDoList.jsp");
		dispatcher.forward(request, response);
	}
	/*
	private MockItemsService itemsService = new MockItemsService();

	
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // Retrieve user input
	 * String category = request.getParameter("category"); String items =
	 * request.getParameter("items"); String colorCode =
	 * request.getParameter("colorCode");
	 * 
	 * 
	 * 
	 * // Add the new to-do item itemsService.addNewToDoItem(session,category,
	 * items);
	 * 
	 * 
	 * 
	 * HttpSession session = request.getSession(true); ArrayList<ToDoItems>
	 * toDoItems = (ArrayList<ToDoItems>) session.getAttribute("toDoItems"); if
	 * (toDoItems == null) { toDoItems = new ArrayList<>(); }
	 * 
	 * ToDoItems newItem = new ToDoItems(); newItem.setCategory(category);
	 * newItem.setColorCode(colorCode); newItem.setItems(items);
	 * 
	 * int newIndex = toDoItems.size(); newItem.setId(newIndex);
	 * 
	 * toDoItems.add(newItem);
	 * 
	 * session.setAttribute("toDoItems", MockDatabase.toDoItems);
	 * 
	 * response.sendRedirect("/" + Configs.APP + "/toDoList");
	 * 
	 * }
	 */
}
