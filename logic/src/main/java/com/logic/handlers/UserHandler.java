package com.logic.handlers;

import com.domain.interfaces.handlers.IUserHandler;
import com.domain.models.User;
import com.logic.components.UserComponent;
import com.persistence.services.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHandler implements IUserHandler {


    @Setter
    private UserService userService;

    @Setter
    private UserComponent userComponent;

    @Autowired
    public UserHandler(UserService service, UserComponent component){
        userService = service;
        userComponent = component;
    }


    @Override
    public User Login(String email, String password) {
        return userComponent.Login(email,password);
    }

    @Override
    public User getUser(long id) {
        return userService.getUser(id);
    }

    @Override
    public Object create(Object entity) {
        userService.create(entity);
        return entity;
    }

    @Override
    public Object read(long id) {
        return userService.read(id);
    }

    @Override
    public Iterable readAll() {
        return userService.readAll();
    }

    @Override
    public Object update(Object entity) {
        return userService.update(entity);
    }

    @Override
    public void delete(long id) {
        userService.delete(id);
    }
}
