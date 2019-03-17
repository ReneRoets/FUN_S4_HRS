package com.domain.models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    private String email;
    private long wage;

    protected User() {
    }

    public User(String name, String adress, String email, long wage) {
        this.name = name;
        this.password = adress;
        this.email = email;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + password + '\'' +
                '}';
    }


    public User Login(String email, String password){
        return this;
    }
}
