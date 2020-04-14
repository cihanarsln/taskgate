package com.cihan.taskgate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
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

    @ManyToOne
    private User manager;

    @ManyToOne
    private User member;


}