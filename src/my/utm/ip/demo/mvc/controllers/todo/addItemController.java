package my.utm.ip.demo.mvc.controllers.todo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.utm.ip.demo.mvc.app.Configs;
import my.utm.ip.demo.mvc.models.ToDoItems;
import my.utm.ip.demo.mvc.models.User;
import my.utm.ip.demo.mvc.services.MockDatabase;


@WebServlet("/addItemController")
public class addItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve user input
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	    Date dueTime = null;

        String category = request.getParameter("category");
        String items = request.getParameter("items");
        String colorCode = request.getParameter("colorCode");
        String dueTimeStr = request.getParameter("dueTime"); 
        try {
			dueTime = timeFormat.parse(dueTimeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * // Add the new to-do item itemsService.addNewToDoItem(session,category,
		 * items);
		 */

      
        HttpSession session = request.getSession(false);
		ArrayList<ToDoItems> toDoItems = (ArrayList<ToDoItems>) session.getAttribute("toDoItems");
		if (toDoItems == null) {
			toDoItems = new ArrayList<>();
		}
		
		ToDoItems newItem = new ToDoItems();
		newItem.setCategory(category);
		newItem.setColorCode(colorCode);
		newItem.setItems(items);
		newItem.setDueTime(dueTime);
		User user = (User) request.getSession().getAttribute("user");
		int userID = user.getId();
		newItem.setUserId(userID);
		
		int newIndex = toDoItems.size();
		newItem.setId(newIndex);

		toDoItems.add(newItem);

		session.setAttribute("toDoItems", toDoItems);

		response.sendRedirect("/" + Configs.APP + "/toDoList");

	}

}
