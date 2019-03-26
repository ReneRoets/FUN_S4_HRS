package com.domain.interfaces.rest;

import org.springframework.http.ResponseEntity;

public interface IUserController {

    ResponseEntity create(String name, String password, String email, long wage);

    ResponseEntity read(int id);

    ResponseEntity update(String name, String password, String email, long wage);

    ResponseEntity delete(int id);
}
