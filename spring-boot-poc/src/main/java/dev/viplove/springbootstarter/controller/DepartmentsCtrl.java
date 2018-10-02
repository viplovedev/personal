package dev.viplove.springbootstarter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentsCtrl {

	@GetMapping(value="/finance")
	public ResponseEntity<String> finance() {
		ResponseEntity<String> retval = new ResponseEntity<>("This is the finance dept.",HttpStatus.OK);
		return retval;
	}

	@GetMapping(value="/accounts")
	public ResponseEntity<String> accounts() {
		ResponseEntity<String> retval = new ResponseEntity<>("This is the accounts dept.",HttpStatus.OK);
		return retval;
	}

	@GetMapping(value="/marketing")
	public ResponseEntity<String> marketing() {
		ResponseEntity<String> retval = new ResponseEntity<>("This is the marketing dept.",HttpStatus.OK);
		return retval;
	}

	@GetMapping(value="/software")
	public ResponseEntity<String> software() {
		ResponseEntity<String> retval = new ResponseEntity<>("This is the software dept.",HttpStatus.OK);
		return retval;
	}
}
