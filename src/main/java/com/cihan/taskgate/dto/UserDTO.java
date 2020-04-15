package com.cihan.taskgate.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {

    private long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Set<RoleDTO> roles;
}
