package com.logic.handlers;

import com.domain.interfaces.IUserHandler;
import com.domain.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserHandler implements IUserHandler {

    @Override
    public User Login(String email, String password) {
        //TODO: Validate login information and return user if login is correct
        return new User("","","",1);
    }
}
