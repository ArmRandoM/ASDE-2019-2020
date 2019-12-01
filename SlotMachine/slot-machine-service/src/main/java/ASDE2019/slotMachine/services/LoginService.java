package ASDE2019.slotMachine.services;
import java.util.Map;

import org.springframework.stereotype.Service;

import ASDE2019.slotMachine.model.Person;

@Service
public class LoginService {
	
	public boolean login(String username, String password, Map<String, Person> username_persons) {
		if(username_persons.containsKey(username) && username_persons.get(username).getPassword().equals(password))
			return true;
		else if (username_persons.containsKey(username) && !username_persons.get(username).getPassword().equals(password))
			return false;
		else if(username.length() > 8 && username.length() < 20 && password.length() > 8 && password.length() < 20) {
			username_persons.put(username, new Person(username,password,200));
			return true;
		}
		else
			return false;
	}
}