package com.domain.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class HourRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private User user;
    private Date startTime;
    private Date endTime;
    @OneToOne
    private Project project;

    protected HourRegistration() {
    }

    public HourRegistration(User user, Date startTime, Date endTime, Project project) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.project = project;
    }

    public HourRegistration(User user, Date startTime, Project project) {
        this.user = user;
        this.startTime = startTime;
        this.project = project;
    }

    @Override
    public String toString() {
        return "HourRegistration{" +
                "id=" + id +
                ", user=" + user +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", project=" + project +
                '}';
    }
}
