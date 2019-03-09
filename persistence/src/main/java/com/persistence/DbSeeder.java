package com.persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.persistence.repositories.UserRepository;

@Component
public class DbSeeder implements CommandLineRunner {

    private UserRepository repository;

    public DbSeeder(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
