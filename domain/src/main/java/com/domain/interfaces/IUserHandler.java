package com.domain.interfaces;

import com.domain.models.User;

public interface IUserHandler {
    User Login(String email, String password);
    User getUser(long id);
}
