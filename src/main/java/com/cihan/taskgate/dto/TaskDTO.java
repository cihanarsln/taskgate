package com.cihan.taskgate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskDTO {

    private long id;
    private String title;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Istanbul")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Istanbul")
    private Date dueDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Istanbul")
    private Date finishDate;
    private int difficulty;
    private UserDTO manager;
    private UserDTO member;

}
