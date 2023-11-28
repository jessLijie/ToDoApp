package my.utm.ip.demo.mvc.models;

public class User {
	
	private String realname;
	private String username;
	private String password;
	private Boolean authenticated;
	
	public User() {
        // No-argument constructor
    }
	
	public User(String realname, String username, String password) {
		super();
		this.realname=realname;
		this.username = username;
		this.password = password;
		this.authenticated = false;
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

	public void setRealName(String realname) {
		this.realname = realname;
	}

	
}
