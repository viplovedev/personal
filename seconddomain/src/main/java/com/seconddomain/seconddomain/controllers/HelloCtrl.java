package com.seconddomain.seconddomain.controllers;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCtrl {
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello() throws IOException {
		String s = "Hello!";
		System.out.println(s);
		
		/**headers*/
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"http://localhost:8090");
		
		
		BodyBuilder ok = ResponseEntity.ok();
		ok.headers(headers);
		ResponseEntity<String> response = ok.body(s);
		
		return response;
	}
}
