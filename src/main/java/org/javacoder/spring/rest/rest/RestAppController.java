package org.javacoder.spring.rest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestAppController {
	
	//add code for "/hello" endpoint
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	
}
