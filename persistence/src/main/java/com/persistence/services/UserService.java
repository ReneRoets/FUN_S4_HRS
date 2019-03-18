package com.persistence.services;

import com.domain.models.User;
import com.persistence.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Qualifier("UserRepository")
    @Autowired
    private IUserRepository iUserRepository;


//    public UserService(IUserRepository iUserRepository) {
//        this.iUserRepository = iUserRepository;
//    }

    public User getUser(long id) {
        return iUserRepository.findById(id).orElse(null);
    }

    public User getUser(String email) {
        Iterable<User> users = iUserRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }
}
