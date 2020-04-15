package com.cihan.taskgate.service.base;

import com.cihan.taskgate.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

    UserDTO save(UserDTO userDTO);

    UserDTO findById(long id);

    List<UserDTO> findAll();

    void deleteById(long id);

}
