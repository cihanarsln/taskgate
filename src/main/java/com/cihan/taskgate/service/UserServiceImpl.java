package com.cihan.taskgate.service;

import com.cihan.taskgate.dto.UserDTO;
import com.cihan.taskgate.mapper.UserMapper;
import com.cihan.taskgate.model.User;
import com.cihan.taskgate.repository.UserRepository;
import com.cihan.taskgate.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptEncoder;

    @Override
    public UserDTO save(UserDTO userDTO) {
        userDTO.setPassword(bCryptEncoder.encode(userDTO.getPassword()));
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
