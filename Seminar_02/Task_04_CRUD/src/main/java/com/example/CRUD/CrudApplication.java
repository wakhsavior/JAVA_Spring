package com.example.CRUD;

import com.example.CRUD.controllers.UserController;
import com.example.CRUD.repositories.UserRepository;
import com.example.CRUD.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(CrudApplication.class, args);
		System.out.println(context.getBean(UserController.class));
		System.out.println(context.getBean(UserRepository.class));
		System.out.println(context.getBean(UserService.class));
		System.out.println(context.getBean(JdbcTemplate.class));
	}

}
