package com.cihan.taskgate.controller;

import com.cihan.taskgate.dto.TaskDTO;
import com.cihan.taskgate.service.base.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/taskgate/task")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    @ResponseBody
    public TaskDTO save(@RequestBody TaskDTO taskDTO){
        return taskService.save(taskDTO);
    }

    @GetMapping("/id")
    @ResponseBody
    public TaskDTO findById(@RequestParam("id") long id){
        return taskService.findById(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<TaskDTO> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/member")
    @ResponseBody
    public List<TaskDTO> findAllByMembers(@RequestParam String username){
        return taskService.findAllByMember_Username(username);
    }

    @PatchMapping("/finish")
    @ResponseBody
    public TaskDTO finishTask(@RequestParam long id){
        return taskService.finishTask(id);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") long id){
        taskService.deleteById(id);
    }

}
