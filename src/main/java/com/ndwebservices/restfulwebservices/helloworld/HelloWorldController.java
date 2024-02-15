package com.ndwebservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "hello world";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public helloworldBean helloworldBean() {
		return new helloworldBean("hello world");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public helloworldBean helloworldPathVariable(@PathVariable String name) {
		return new helloworldBean(String.format("hello , %s",name));
	}
	
	@GetMapping(path = "/hello-world/path-variable2/{num}")
	public helloworldBean age(@PathVariable int num) {
		return new helloworldBean("hi" + num);
	}
	
}
