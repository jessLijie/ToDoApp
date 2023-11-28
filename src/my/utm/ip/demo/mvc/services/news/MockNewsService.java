package my.utm.ip.demo.mvc.services.news;

import java.util.ArrayList;
import java.util.Date;

import my.utm.ip.demo.mvc.models.News;
import my.utm.ip.demo.mvc.services.MockDatabase;

public class MockNewsService implements NewsService {

	@Override
	public void init() {

	}

	public News news(int id, String title, String content, Date date, String imageUrl, String publisher, String author) {
		for (final News news : MockDatabase.news) {
			return news;
		}

		return null;

	}

	@Override
	public ArrayList<News> getAllNews() {
        ArrayList<News> newsList = new ArrayList<>();
        return newsList;
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
