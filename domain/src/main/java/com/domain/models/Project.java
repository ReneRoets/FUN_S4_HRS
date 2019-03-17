package com.domain.models;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Customer projectOwner;
    private String projectName;
    private String projectDescription;
    private long budget;


    protected Project() {
    }

    public Project(Customer projectOwner, String projectName, String projectDescription, long budget) {
        this.projectOwner = projectOwner;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.budget = budget;
    }
}
