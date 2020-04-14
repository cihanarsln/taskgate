package com.cihan.taskgate.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Set<RoleDTO> roles;

}
