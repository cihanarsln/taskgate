package com.cihan.taskgate.service;

import com.cihan.taskgate.dto.RoleDTO;
import com.cihan.taskgate.mapper.RoleMapper;
import com.cihan.taskgate.repository.RoleRepository;
import com.cihan.taskgate.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        return roleMapper.toRoleDTO(roleRepository.save(roleMapper.toRole(roleDTO)));
    }

    @Override
    public RoleDTO findById(long id) {
        return roleMapper.toRoleDTO(roleRepository.getOne(id));
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleMapper.toRoleDTOList(roleRepository.findAll());
    }

    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }
}
