package my.utm.ip.demo.mvc.services.todo;

import java.util.ArrayList;
import java.util.Date;

import my.utm.ip.demo.mvc.models.ToDoItems;
import my.utm.ip.demo.mvc.services.Service;

public interface ItemsService extends Service {

    public ToDoItems toDoItems(int id, int userId, String category, String items, String colorCode, Date dueTime);
    public ArrayList<ToDoItems> getAllItems();
  
    
}
