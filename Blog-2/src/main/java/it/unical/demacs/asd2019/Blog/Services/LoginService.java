package it.unical.demacs.asd2019.Blog.Services;
import org.springframework.stereotype.Service;

import it.unical.demacs.asd2019.Blog.Model.BlogPost;

/* Now we have a Controller that is not good because we put logic in the controller and typically  the logic is not in the controller
 * but in the services.
 * We want to create a service and in this case we want to create a service to handle the login.
 * In order to create a service we have to use the annotation @Service.
 * When we annotate this class with @Service it goes automatically in the spring container.
 */

@Service
public class LoginService 
{
	public Boolean canLogin(String username, String password)
	{
		return username.equals("CICCIO") && password.equals("CICCIO");
	}
	
	/* Here we want to implement a function that return the last post in the application, the aim is not to return simply a string
	 * but to write a post.
	 * In this case we return a Java object, to transform it in a message we have to use JSON, and automatically it will
	 * translated into JSON by Spring.
	 * We cannot test it in the browser because in the browser when we write a request this is a get request while the RestController
	 * is handling post requests.
	 * But typically request to a Web Service are post request and to test it we need some tools, there are several tools on the internet 
	 * one of these is PostMan.
	 * PostMan is like a browser but it is able to submit post request.
	 */
	public BlogPost getLatestPost()
	{
		return new BlogPost("CICCIO","Pizza", "I love pizza!");
	}
}
