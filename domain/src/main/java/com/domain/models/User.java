package com.domain.models;

import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class User extends ResourceSupport{

    public Link getId() {
        return new Link(id.toString());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
