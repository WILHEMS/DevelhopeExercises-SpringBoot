package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

	@GetMapping("/")
	public ResponseEntity<String> index() {
		if (new Date().getHours() > 10){
			return ResponseEntity.badRequest().body("It's not morning");
		}

		return ResponseEntity.ok("Greetings from Spring Boot!");
	}

	@GetMapping("/kogada")
	public String kogada() {
		return "Greetings from Bolton Kogada!";
	}

}
