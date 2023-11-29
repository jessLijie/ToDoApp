package my.utm.ip.demo.mvc.services.todo;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import my.utm.ip.demo.mvc.models.ToDoItems;
import my.utm.ip.demo.mvc.services.MockDatabase;

public class MockItemsService implements ItemsService {

	@Override
	public void init() {

	}

	public ToDoItems toDoItems(int id, int userId, String category, String items, String colorCode, Date dueTime) {
		for (final ToDoItems toDoItems : MockDatabase.toDoItems) {
			return toDoItems;
		}

		return null;

	}

	@Override
	public ArrayList<ToDoItems> getAllItems() {
        ArrayList<ToDoItems> toDoItems = new ArrayList<>();
        return toDoItems;
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	private ArrayList<ToDoItems> getSessionToDoItems(HttpSession session) {
        // Retrieve existing items from the session or create a new list
        ArrayList<ToDoItems> toDoItems = (ArrayList<ToDoItems>) session.getAttribute("toDoItems");

        if (toDoItems == null) {
            toDoItems = new ArrayList<>();
            session.setAttribute("toDoItems", toDoItems);
        }

        return toDoItems;
    }

    public void addNewToDoItem(HttpSession session, String category, String items) {
        ArrayList<ToDoItems> toDoItems = getSessionToDoItems(session);
        int newId = toDoItems.size() + 1;
        ToDoItems newToDoItem = new ToDoItems(newId, 1, category, items, "#3498db", null);
        toDoItems.add(newToDoItem);
    }

}
