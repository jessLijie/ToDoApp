package my.utm.ip.demo.mvc.models;

import my.utm.ip.demo.mvc.services.MockDatabase;

public class User {
	private int id;
	private String realname;
	private String username;
	private String password;
	private Boolean authenticated;
	
	public User() {
        // No-argument constructor
    }
	
	public User(int id, String realname, String username, String password) {
		super();
		this.id = id;
		this.realname=realname;
		this.username = username;
		this.password = password;
		this.authenticated = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean isAuthenticated) {
		this.authenticated = isAuthenticated;
	}
	public String getRealName() {
		return realname;
	}
	
	public String getRealNameById(int id) {
	    for (User user :  MockDatabase.users) {
	        if (user.getId() == id) {
	            return user.getRealName();
	        }
	    }
	    return null;
	}

	public void setRealName(String realname) {
		this.realname = realname;
	}

	
}
