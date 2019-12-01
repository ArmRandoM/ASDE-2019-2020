package it.unical.demacs.asd2019.Blog.Model;

public class BlogPost 
{
	private String author;
	private String message;
	private String title;
	
	public BlogPost(String author, String message, String title) 
	{
		super();
		this.author = author;
		this.message = message;
		this.title = title;
	}

	public String getAuthor() 
	{
		return author;
	}
	
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	
	public String getMessage() 
	{
		return message;
	}
	
	public void setMessage(String message) 
	{
		this.message = message;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
}
