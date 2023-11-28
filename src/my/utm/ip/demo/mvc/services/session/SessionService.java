package my.utm.ip.demo.mvc.services.session;

import my.utm.ip.demo.mvc.services.Service;

public interface SessionService extends Service {

	public void set(String name, Object data);

	public Object get(String name);

	public void delete(String name);

}
