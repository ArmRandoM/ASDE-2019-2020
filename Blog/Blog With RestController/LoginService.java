package it.unical.demacs.asd2019.Blog.Services;
import org.springframework.stereotype.Service;

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
}
