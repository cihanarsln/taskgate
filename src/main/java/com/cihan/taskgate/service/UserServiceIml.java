package com.cihan.taskgate.service;

import com.cihan.taskgate.dto.UserDTO;
import com.cihan.taskgate.mapper.UserMapper;
import com.cihan.taskgate.repository.UserRepository;
import com.cihan.taskgate.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO save(UserDTO userDTO) {
        return userMapper.toUserDTO(userRepository.save(userMapper.toUser(userDTO)));
    }

    @Override
    public UserDTO findById(long id) {
        return userMapper.toUserDTO(userRepository.getOne(id));
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
