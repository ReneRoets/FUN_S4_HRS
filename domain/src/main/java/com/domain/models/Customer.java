package com.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String adress;

    protected Customer() {
    }

    public Customer(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }
}
