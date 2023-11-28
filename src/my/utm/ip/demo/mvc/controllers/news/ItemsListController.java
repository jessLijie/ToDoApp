package my.utm.ip.demo.mvc.controllers.news;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.utm.ip.demo.mvc.app.Configs;
import my.utm.ip.demo.mvc.services.MockDatabase;
import my.utm.ip.demo.mvc.services.news.MockItemsService;
import my.utm.ip.demo.mvc.models.User;

@WebServlet("/toDoList")
public class ItemsListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
    	 // Check if the user is authenticated
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getAuthenticated()) {
            // Redirect to the login page if the user is not authenticated
            response.sendRedirect("/" + Configs.APP + "/login/login.jsp");
            return;
        }
       
        request.setAttribute("toDoItems", MockDatabase.toDoItems);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/todo/toDoList.jsp");
        dispatcher.forward(request, response);
    }
    
    private MockItemsService itemsService = new MockItemsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input
        String category = request.getParameter("category");
        String items = request.getParameter("items");

        // Add the new to-do item
        HttpSession session = request.getSession();
        itemsService.addNewToDoItem(session,category, items);

        // Redirect back to the to-do list page
        response.sendRedirect("/" + Configs.APP + "/toDoList");

    }
}
