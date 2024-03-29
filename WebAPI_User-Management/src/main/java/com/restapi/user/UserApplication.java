package com.restapi.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.logging.Logger;


@SpringBootApplication
@EnableSwagger2
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
