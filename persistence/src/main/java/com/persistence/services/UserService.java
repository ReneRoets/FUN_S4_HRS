package com.persistence.services;

import com.domain.interfaces.ICRUD;
import com.domain.models.User;
import com.persistence.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements ICRUD {

    @Qualifier("UserRepository")
    @Autowired
    private IUserRepository iUserRepository;


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

    @Override
    public Object create(Object entity) {
        iUserRepository.save((User)entity);
        return entity;
    }

    @Override
    public Object read(long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public Iterable readAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Object update(Object entity) {
        iUserRepository.save((User)entity);
        return entity;
    }

    @Override
    public void delete(long id) {
        iUserRepository.deleteById(id);
    }
}
