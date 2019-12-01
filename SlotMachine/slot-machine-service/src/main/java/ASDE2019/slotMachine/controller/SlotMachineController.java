package ASDE2019.slotMachine.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ASDE2019.slotMachine.model.Person;
import ASDE2019.slotMachine.services.LoginService;
import ASDE2019.slotMachine.services.PlayService;

@RestController
public class SlotMachineController {
	
	private Map<String,Person> username_persons = new HashMap<String, Person>();
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PlayService playService;
	
	@CrossOrigin
	@PostMapping("/login")
	public boolean login(@RequestParam String username, @RequestParam String password) {
		return loginService.login(username, password, username_persons); 
	}
	
	@CrossOrigin
	@PostMapping("/coinsNumber")
	public Integer getCoinsNumber(@RequestParam String username) {
		return username_persons.get(username).getCoinsNumber(); 
	}
	
	@CrossOrigin
	@PostMapping("/play")
	public ArrayList<Integer> play(@RequestParam String username, @RequestParam Integer coinsNumber){
		return playService.play(username, coinsNumber, username_persons);
	}
	
	@CrossOrigin
	@GetMapping("/getAllUsers")
	public List<Person> getAllUsers(){
		List<Person> persons = new ArrayList<>();
		Iterator<Entry<String, Person>> it = username_persons.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        persons.add((Person) pair.getValue());
	    }
		persons.sort(Comparator.comparingInt(Person::getCoinsNumber).reversed());
		return persons;
	}
}
