package my.utm.ip.demo.mvc.models;

import java.util.Date;

public class ToDoItems {
	private int id;
	private int userId;
	private String category;
	private String items;
	private String colorCode;
	private Date dueTime;
	
	public ToDoItems(int id, int userId, String category, String items, String colorCode, Date dueTime) {
		this.id = id;
		this.userId = userId;
		this.category = category;
		this.items = items;
		this.colorCode = colorCode;
		this.dueTime = dueTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public Date getDueTime() {
		return dueTime;
	}
	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}
	
	
}
