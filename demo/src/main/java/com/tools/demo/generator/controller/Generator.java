package com.tools.demo.generator.controller;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableEurekaClient
@RequestMapping("/")
public class Generator {

	@GetMapping("/html")
	public String html() {
		return "/system-generator/systemGenerator";
	}
}
