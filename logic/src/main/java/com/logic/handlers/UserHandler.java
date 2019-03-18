package com.logic.handlers;

import com.domain.interfaces.IUserHandler;
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
}
