package com.vikram.explorespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vikram.explorespringboot")
public class ExploreSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExploreSpringBootApplication.class, args);

	}

}
