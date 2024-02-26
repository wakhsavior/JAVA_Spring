package ru.gb.MyRickAndMortyAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.gb.MyRickAndMortyAPI.configs.ConfigCustomer;

@SpringBootApplication
public class MyRickAndMortyApiApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(MyRickAndMortyApiApplication.class, args);

	}

}
