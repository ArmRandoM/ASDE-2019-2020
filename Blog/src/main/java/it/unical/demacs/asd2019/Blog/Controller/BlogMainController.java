package it.unical.demacs.asd2019.Blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.demacs.asd2019.Blog.Services.LoginService;

/*In this class i want to create my first CONTROLLER
 *In order to create a CONTROLLER we annotate the class with @Controller
 */
@Controller
public class BlogMainController 
{
	/* In this case we have a controller that is already running:
	 * 	1. the requests from the root of the application will be despatched to this controller;
	 * 	2. the controller returns a welcome message;
	 * 	3. the welcome message is embedded in the body of the response (usually an HTML page).
	 *  4. the body of the message will be rendered by the browser.
	 * In order to create this kind of method we have to annotate the method with:
	 *   1. @RequestMapping we have to handle the request:
	 *   	1) we specified / in order to define a method that can be executed in the root of the application;
	 *   	2) the @RequestMapping returns the name of the view that is responsible to rendering the result but 
	 *		we use it as a web service and for rendering we will use something different;
	 *   2. for now we want to return a string as a body of the message, in order to do this we add @ResponseBody to the Method*
	 *   Try with: http://localhost:8080/ 
	 */
	
	@RequestMapping("/")
	@ResponseBody
	public String welcomeMessage()
	{
		return "<h1> Welcome to the blog </h1>";
	}
	/* Now we focused on the dependency injection, indeed the controller will delegate the control of the login credenital
	 * to the LoginService.
	 */
	/* In the case in which we want to handle the request going to /login of the application we have to add some additional mappings.
	 * We want to have two possible outputs:
	 *  - SUCCESS: the credentials are correct;
	 *  - FAIL: the credentials are not correct;
	 * In this case we need the client, the username and the password that come from the client.
	 * In this case we will use @GetMapping. 
	 * @GetMapping and @RequestMapping by default are the same, because @RequestMapping by default accepts a method and the default method is get.
	 * Try with: http://localhost:8080/login?username=CICCIO&password=CICCIO 
	 * In order to say that the LoginService is a dependency that is automatically wired by spring we need to add the annotation @AutoWired
	   and Spring will put a singleton instance of the LoginService in the private field of the controller.
	 */
	
	@Autowired
	private LoginService loginService = new LoginService();
	
	@GetMapping("/login")
	@ResponseBody
	public String loginManager(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		return (loginService.canLogin(username, password))? "<h1 style=\"color:green\">Success</h1>" : "<h1 style=\"color:red\">Fail</h1>";
	}
}
