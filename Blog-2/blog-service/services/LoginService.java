package it.unical.demacs.asde2019.blog.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean login(String username, String pass) {
		return username.equals("ciccio") && pass.equals("ciccio");
	}
}
