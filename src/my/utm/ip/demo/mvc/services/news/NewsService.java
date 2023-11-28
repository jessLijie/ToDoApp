package my.utm.ip.demo.mvc.services.news;

import java.util.ArrayList;
import java.util.Date;

import my.utm.ip.demo.mvc.models.News;
import my.utm.ip.demo.mvc.services.Service;

public interface NewsService extends Service {

    public News news(int id, String title, String content, Date date, String imageUrl, String publisher, String author);
    public ArrayList<News> getAllNews();
  
    
}
