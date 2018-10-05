package com.firstdomain.demo.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSCtrl {
	
	@GetMapping("/js")
	public String getJS() throws IOException {
		String s = readFile("C:\\Users\\Viplove\\Downloads\\firstdomain\\src\\main\\resources\\templates\\js\\ajax-1.js");
		System.out.println(s);
		return s;
	}
	
	@GetMapping("/hello")
	public String hello() throws IOException {
		String s = "Hello!";
		System.out.println(s);
		return s;
	}
	
	
	private String readFile(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		byte[] buffer = new byte[10];
		StringBuilder sb = new StringBuilder();
		while (fis.read(buffer) != -1) {
			sb.append(new String(buffer));
			buffer = new byte[10];
		}
		fis.close();

		String content = sb.toString();
		return content;
	}

}
