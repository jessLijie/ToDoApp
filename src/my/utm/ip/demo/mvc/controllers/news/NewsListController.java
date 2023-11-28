package my.utm.ip.demo.mvc.controllers.news;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.utm.ip.demo.mvc.app.Configs;
import my.utm.ip.demo.mvc.services.MockDatabase;
import my.utm.ip.demo.mvc.models.User;

@WebServlet("/newsList")
public class NewsListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
    	 // Check if the user is authenticated
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getAuthenticated()) {
            // Redirect to the login page if the user is not authenticated
            response.sendRedirect("/" + Configs.APP + "/login/login.jsp");
            return;
        }
       
        request.setAttribute("news", MockDatabase.news);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/news/newsList.jsp");
        dispatcher.forward(request, response);
    }
}
