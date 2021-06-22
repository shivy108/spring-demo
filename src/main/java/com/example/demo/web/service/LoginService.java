package com.example.demo.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String name, String password) {
		return name.equalsIgnoreCase("shiv") && password.equalsIgnoreCase("shiv");
	}

}
