package com.logic.components;

import com.domain.models.User;
import com.persistence.services.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserComponent {

    @Setter
    private UserService userService;

    @Autowired
    public UserComponent(UserService userService) {
        this.userService = userService;
    }

    public User Login(String email, String password){
        User user = userService.getUser(email);
        if (Objects.equals(user.getEmail(), email) && Objects.equals(user.getPassword(), password))
            return user;
        return null;
    }
}
