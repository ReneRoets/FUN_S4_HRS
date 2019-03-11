package com.persistence;

import com.domain.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.persistence.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

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
