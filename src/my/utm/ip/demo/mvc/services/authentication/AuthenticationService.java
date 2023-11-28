package my.utm.ip.demo.mvc.services.authentication;

import my.utm.ip.demo.mvc.models.User;
import my.utm.ip.demo.mvc.services.Service;

public interface AuthenticationService extends Service {
	public User login(String username, String password);

	public void logout();

	public void changePassword(String currentPassword, String newPassword);
}
