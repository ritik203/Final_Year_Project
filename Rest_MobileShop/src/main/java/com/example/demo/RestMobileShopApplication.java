package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.sunbeam")
@SpringBootApplication
public class RestMobileShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMobileShopApplication.class, args);
	}

}
