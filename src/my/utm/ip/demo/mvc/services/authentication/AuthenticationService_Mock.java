package my.utm.ip.demo.mvc.services.authentication;

import my.utm.ip.demo.mvc.models.User;
import my.utm.ip.demo.mvc.services.MockDatabase;

public class AuthenticationService_Mock implements AuthenticationService {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public AuthenticationService_Mock() {
	}

	@Override
	public User login(String username, String password) {

		for (final User u : MockDatabase.users) {
			if (username.equals(u.getUsername()) && password.equals(u.getPassword()))
				return new User(u.getRealName(), u.getUsername(), u.getPassword());
		}

		return null;
	}

	@Override
	public void changePassword(String currentPassword, String newPassword) {
	}

	@Override
	public void logout() {
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
