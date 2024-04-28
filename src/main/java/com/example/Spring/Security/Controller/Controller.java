package com.example.Spring.Security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/welcome")
	public String welcomemessage() {
		return "Hello alll!!!!";
	}
	
	@GetMapping("/endpoint")
	public String endpoint() {
		return "Hello without authentication!!!!";
	}
}
