package com.cihan.taskgate.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class TaskDTO {

    private long id;
    private String title;
    private String description;
    private Date startDate;
    private Date dueDate;
    private Date finishDate;
    private int difficulty;
    private Set<UserDTO> managers;
    private Set<UserDTO> members;

}
