package com.example.ORMDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(OrmDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrmDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository){
		return (args -> {
			//repository.save(new com.example.ORMDemo.User("Rene", "Berkel enschot"));

			for (User user : repository.findAll()){
				log.info(user.toString());
			}
		});
	}

}
