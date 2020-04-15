package com.cihan.taskgate.service;

import com.cihan.taskgate.dto.TaskDTO;
import com.cihan.taskgate.mapper.TaskMapper;
import com.cihan.taskgate.repository.TaskRepository;
import com.cihan.taskgate.service.base.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        return taskMapper.toTaskDTO(taskRepository.save(taskMapper.toTask(taskDTO)));
    }

    @Override
    public TaskDTO findById(long id) {
        return taskMapper.toTaskDTO(taskRepository.getOne(id));
    }

    @Override
    public List<TaskDTO> findAll() {
        return taskMapper.totaskDTOList(taskRepository.findAll());
    }

    @Override
    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }
}
