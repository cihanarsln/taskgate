package com.cihan.taskgate.service.base;

import com.cihan.taskgate.dto.RoleDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleService {

    RoleDTO save(RoleDTO roleDTO);

    RoleDTO findById(long id);

    List<RoleDTO> findAll();

    void deleteById(long id);

}
