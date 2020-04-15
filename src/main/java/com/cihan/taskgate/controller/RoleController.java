package com.cihan.taskgate.controller;

import com.cihan.taskgate.dto.RoleDTO;
import com.cihan.taskgate.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/taskgate/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    @ResponseBody
    public RoleDTO save(@RequestBody RoleDTO roleDTO){
        return roleService.save(roleDTO);
    }

    @GetMapping("/id")
    @ResponseBody
    public RoleDTO findById(@RequestParam("id") long id){
        return roleService.findById(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<RoleDTO> findAll(){
        return roleService.findAll();
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") long id){
        roleService.deleteById(id);
    }

}
