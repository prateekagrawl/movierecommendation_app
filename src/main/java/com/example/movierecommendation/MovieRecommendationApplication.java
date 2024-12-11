package com.example.movierecommendation;

import com.example.movierecommendation.domain.MyUser;
import com.example.movierecommendation.service.MyUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommendationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommendationApplication.class, args);
	}

	@Autowired
	MyUserService myUserService;

	@Override
	public void run(String... args) throws Exception {
		myUserService.addUser(new MyUser("john","john123","Admin"));
		myUserService.addUser(new MyUser("jenny","jenny123","User"));
	}
}
