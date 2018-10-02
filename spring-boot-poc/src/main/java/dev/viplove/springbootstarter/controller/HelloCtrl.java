package dev.viplove.springbootstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.viplove.springbootstarter.service.AutowireDependent;
import dev.viplove.springbootstarter.service.AutowireService;

@RestController
public class HelloCtrl {
	
	@Autowired
	AutowireService autowireService;

	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		String hello = "Hello!";
		ResponseEntity response = new ResponseEntity<String>(hello, HttpStatus.OK);
		return response;
	}

	@GetMapping("/private/hello")
	public ResponseEntity<String> t(){
		ResponseEntity response = new ResponseEntity<String>("t", HttpStatus.OK);
		return response;
	}

	@GetMapping("/hisab")
	public ResponseEntity<String> hisab(){
		ResponseEntity response = new ResponseEntity<String>("Sir! ye raha hisab", HttpStatus.OK);
		return response;
	}
}
