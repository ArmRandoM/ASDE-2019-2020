package it.unical.demacs.asde2019.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unical.demacs.asde2019.blog.model.BlogPost;
import it.unical.demacs.asde2019.blog.services.BlogService;
import it.unical.demacs.asde2019.blog.services.LoginService;

/* We will develop the business logic in Spring using Rest Components and adding
 * @CrossOrigin and then from the React application we use Axios to perform request 
 * to services.
 * In React we render the stuff that we get from the services.
 * Using @CrossOrigin you can specify that you can perform request on other urls.
 * We are using @CrossOrigin because otherwise when we open a React application we
 * can only perform a AJAX request to React application itself, but we want to per-
 * form AJAX request to Spring (to another service).
 * Indeed, we added the @CrossOrigin annotation and React will be able to perform
 * request.
 * The Aim of the @RestController is to get the requests and to ask to the services 
 * to handle the request.
 * We use the @GetMapping specifying the urls and then we ask to the service to give
 * us the latest post or all the posts.
 */

@RestController
public class BlogMainController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/")
	public String welcomeMessage() {
		return "<h1>Welcome to the blog</h1>";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		if(loginService.login(username, password)) {
			return "Success";
		}
		return "Failed to login";
	}
	
	// This method allows to get the latest post
	@CrossOrigin
	@GetMapping("/getLatestPost") 
	public BlogPost getLatestPost() {
		return blogService.getLatestPost();
	}
	
	// This method allows to get all posts
	@CrossOrigin
	@GetMapping("/getAllPosts") 
	public List<BlogPost> getAllPosts() {
		return blogService.getAllPosts();
	}
}
