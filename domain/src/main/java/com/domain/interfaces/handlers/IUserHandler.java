package com.domain.interfaces.handlers;

import com.domain.interfaces.ICRUD;
import com.domain.models.User;

public interface IUserHandler extends ICRUD {
    User Login(String email, String password);
    User getUser(long id);
}
