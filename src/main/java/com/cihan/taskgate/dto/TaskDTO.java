package com.cihan.taskgate.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDTO {

    private long id;
    private String title;
    private String description;
    private Date startDate;
    private Date dueDate;
    private Date finishDate;
    private int difficulty;
    private UserDTO manager;
    private UserDTO member;

}
