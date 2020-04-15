package com.cihan.taskgate.mapper;

import com.cihan.taskgate.dto.RoleDTO;
import com.cihan.taskgate.model.Role;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Named("toRole")
    Role toRole(RoleDTO roleDTO);

    @Named("toRoleDTO")
    RoleDTO toRoleDTO(Role role);

    @IterableMapping(qualifiedByName = "toRole")
    List<Role> toRoleList(List<RoleDTO> roleDTOList);

    @IterableMapping(qualifiedByName = "toRoleDTO")
    List<RoleDTO> toRoleDTOList(List<Role> RoleList);

}
