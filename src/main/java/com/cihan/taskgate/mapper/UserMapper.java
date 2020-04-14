package com.cihan.taskgate.mapper;

import com.cihan.taskgate.dto.UserDTO;
import com.cihan.taskgate.model.Role;
import com.cihan.taskgate.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {Role.class})
public interface UserMapper {

    @Named("toUser")
    User toUser(UserDTO userDTO);

    @Named("toUserDTO")
    UserDTO userDTO(User user);

    @IterableMapping(qualifiedByName = "toUser")
    List<User> toUserList(List<UserDTO> userDTOList);

    @IterableMapping(qualifiedByName = "toUserDTO")
    List<UserDTO> toUserDTOList(List<User> userList);

}
