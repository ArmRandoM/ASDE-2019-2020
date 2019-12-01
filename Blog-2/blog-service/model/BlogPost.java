package it.unical.demacs.asde2019.blog.model;

public class BlogPost {

	private int id;
	private String author;
	private String title;
	private String message;

	public BlogPost(int id, String author, String title, String message) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
