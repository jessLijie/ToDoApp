package my.utm.ip.demo.mvc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import my.utm.ip.demo.mvc.models.User;
import my.utm.ip.demo.mvc.models.ToDoItems;

public class MockDatabase {

	public static ArrayList<User> users = new ArrayList<User>();

	static {
		users.add(new User(1,"Wong Li Jie", "user1", "pwd"));
		users.add(new User(2, "Ng Qian Hui", "user2", "pwd"));
		users.add(new User(3, "Jess", "user3", "pwd"));
		users.add(new User(4, "Nickia", "user4", "pwd"));
		users.add(new User(5, "Lee Admin Ho", "admin", "pwd"));
		
	}

	public static ArrayList<ToDoItems> toDoItems = new ArrayList<ToDoItems>();

	static {
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");


			try {
				toDoItems.add(new ToDoItems(1, 1, "Work", "Complete project report", "#3498db", timeFormat.parse("15:00")));
		        toDoItems.add(new ToDoItems(2, 1, "Personal", "Go for a run", "#2ecc71", timeFormat.parse("15:00")));
		        toDoItems.add(new ToDoItems(3, 2, "Study", "Read chapter 5", "#e74c3c", timeFormat.parse("15:00")));
		        toDoItems.add(new ToDoItems(4, 2, "Work", "Prepare presentation", "#3498db", timeFormat.parse("10:30")));
		        toDoItems.add(new ToDoItems(5, 1, "Personal", "Cook dinner", "#2ecc71", timeFormat.parse("18:45")));
		        toDoItems.add(new ToDoItems(6, 2, "Study", "Review lecture notes", "#e74c3c", timeFormat.parse("14:15")));
		        toDoItems.add(new ToDoItems(7, 1, "Work", "Attend team meeting", "#3498db", timeFormat.parse("09:00")));
		        toDoItems.add(new ToDoItems(8, 2, "Personal", "Call family", "#2ecc71", timeFormat.parse("21:30")));
		        toDoItems.add(new ToDoItems(9, 1, "Study", "Complete online course", "#f39c12", timeFormat.parse("12:00")));
		        toDoItems.add(new ToDoItems(10, 2, "Work", "Submit project proposal", "#8e44ad", timeFormat.parse("16:30")));
		        toDoItems.add(new ToDoItems(11, 1, "Study", "Research new technologies", "#f39c12", timeFormat.parse("10:00")));
		        toDoItems.add(new ToDoItems(12, 1, "Personal", "Exercise at the gym", "#3498db", timeFormat.parse("17:30")));
		        toDoItems.add(new ToDoItems(13, 1, "Work", "Attend client meeting", "#e74c3c", timeFormat.parse("14:00")));
		        toDoItems.add(new ToDoItems(14, 1, "Study", "Write research paper", "#2ecc71", timeFormat.parse("16:45")));
		        toDoItems.add(new ToDoItems(15, 2, "Personal", "Plan weekend getaway", "#3498db", timeFormat.parse("19:00")));
		        toDoItems.add(new ToDoItems(16, 2, "Work", "Review project timeline", "#f39c12", timeFormat.parse("11:30")));
		        toDoItems.add(new ToDoItems(17, 2, "Study", "Practice coding challenges", "#8e44ad", timeFormat.parse("13:15")));
		        toDoItems.add(new ToDoItems(18, 2, "Work", "Complete expense report", "#e67e22", timeFormat.parse("09:45")));
		        toDoItems.add(new ToDoItems(19, 3, "Personal", "Read a book", "#2ecc71", timeFormat.parse("20:30")));
		        toDoItems.add(new ToDoItems(20, 3, "Study", "Attend online seminar", "#e74c3c", timeFormat.parse("12:30")));
		        toDoItems.add(new ToDoItems(21, 3, "Work", "Prepare project presentation", "#3498db", timeFormat.parse("15:45")));
		        toDoItems.add(new ToDoItems(22, 3, "Personal", "Try a new recipe", "#f39c12", timeFormat.parse("18:00")));
		        toDoItems.add(new ToDoItems(23, 4, "Work", "Review sales strategy", "#8e44ad", timeFormat.parse("16:00")));
		        toDoItems.add(new ToDoItems(24, 4, "Personal", "Painting session", "#e67e22", timeFormat.parse("14:45")));
		        toDoItems.add(new ToDoItems(25, 4, "Study", "Prepare for exams", "#3498db", timeFormat.parse("11:00")));
		        toDoItems.add(new ToDoItems(26, 4, "Work", "Organize team-building activity", "#2ecc71", timeFormat.parse("17:15")));
		   
			} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}