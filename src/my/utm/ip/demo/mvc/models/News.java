package my.utm.ip.demo.mvc.models;

import java.util.Date;

public class News {

    private int id;
    private String title;
    private String content;
    private Date date;
    private String imageUrl;
    private String publisher; 
    private String author;

    // Constructors

    public News(int id, String title, String content, Date date, String imageUrl, String publisher, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.imageUrl = imageUrl;
        this.publisher = publisher;
        this.author= author;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
