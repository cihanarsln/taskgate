package com.cihan.taskgate.controller;

import com.cihan.taskgate.dto.UserDTO;
import com.cihan.taskgate.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/taskgate/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    @ResponseBody
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping("/id")
    @ResponseBody
    public UserDTO findById(@RequestParam("id") long id){
        return userService.findById(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") long id){
        userService.deleteById(id);
    }

}
