package com.tools.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.tools.demo.*.dao")
@EnableCaching
public class ToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolsApplication.class, args);
	}

}

