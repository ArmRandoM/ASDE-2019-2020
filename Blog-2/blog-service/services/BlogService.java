package it.unical.demacs.asde2019.blog.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import it.unical.demacs.asde2019.blog.model.BlogPost;

/* In this case in the service we have some fake posts defined in order to test
 * to test the functions (in the latest part of the course we will integrate a 
 * persistence layer, in order to have a DB  that stores all the posts).
 * This is a service and typically we want to define a paring among the service
 * and in this case instead of put the data in a DB we put the data directly in
 * this service. 
 * @PostConstruct is a method that is invoked when the bean is instantiated, in 
 * order to instantiate post and create some fake post. 
 * In this case we initialized some object in the init function that is annotated
 * with @PostConstruct, this @PostConstruct will be invoked when the service is 
 * instantiated.
 */

@Service
public class BlogService {
	
	private List<BlogPost> posts;
	
	@PostConstruct
	public void init() {
		posts = new ArrayList<BlogPost>();
		posts.add(new BlogPost(1, "ciccio", "Pizza", "I love pizza"));
		posts.add(new BlogPost(2, "pippo", "Pasta", "Do you guys like pasta?"));
	}
	
	public BlogPost getLatestPost() {
		return posts.get(posts.size()-1);
	}

	public List<BlogPost> getAllPosts() {
		return posts;
	}
}
