package com.cihan.taskgate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private Date startDate;
    private Date dueDate;
    private Date finishDate;
    private int difficulty;

    @ManyToMany
    private Set<User> managers;

    @ManyToMany
    private Set<User> members;
}
