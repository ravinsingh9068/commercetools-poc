package com.test.commercetoolpoc.catalog.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.test.commercetoolpoc.")
public class TestController {
	
	@RequestMapping("/test")
	public ResponseEntity<String> test() {
			return ResponseEntity.ok("Hi");
	}
	
	

}
