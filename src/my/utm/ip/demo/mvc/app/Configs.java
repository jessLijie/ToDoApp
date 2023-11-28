package my.utm.ip.demo.mvc.app;

public class Configs {
	public static String APP = "MVCWebApp";

	public String getUrl(String path) {
		return "/" + APP + "/" + path;
	}
}
