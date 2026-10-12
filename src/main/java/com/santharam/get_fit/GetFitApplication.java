package com.santharam.get_fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.santharam.get_fit", "GlobalExceptionHandler"})
public class GetFitApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetFitApplication.class, args);
	}

}
