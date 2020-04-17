package com.cihan.taskgate.service;

import com.cihan.taskgate.dto.TaskDTO;
import com.cihan.taskgate.mapper.TaskMapper;
import com.cihan.taskgate.repository.TaskRepository;
import com.cihan.taskgate.service.base.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        List<TaskDTO> tasks = findAllByMember_Id(taskDTO.getMember().getId());
        for ( TaskDTO task : tasks) {
            if (task.getFinishDate() == null && (task.getStartDate().compareTo(taskDTO.getStartDate()) * taskDTO.getStartDate().compareTo(task.getDueDate()) >= 0 ||
                task.getStartDate().compareTo(taskDTO.getDueDate()) * taskDTO.getDueDate().compareTo(task.getDueDate()) >= 0)){
                System.out.println("Member ID: " + taskDTO.getMember().getId() + " has another task between these days!");
                return null;
            }
        }
        return taskMapper.toTaskDTO(taskRepository.save(taskMapper.toTask(taskDTO)));
    }

    @Override
    public TaskDTO findById(long id) {
        return taskMapper.toTaskDTO(taskRepository.getOne(id));
    }

    @Override
    public List<TaskDTO> findAll() {
        return taskMapper.toTaskDTOList(taskRepository.findAll());
    }

    @Override
    public List<TaskDTO> findAllByMember_Username(String username) {
        return taskMapper.toTaskDTOList(taskRepository.findAllByMember_Username(username));
    }

    @Override
    public List<TaskDTO> findAllByMember_Id(long id) {
        return taskMapper.toTaskDTOList(taskRepository.findAllByMember_Id(id));
    }

    @Override
    public TaskDTO finishTask(long id) {
        TaskDTO taskDTO = taskMapper.toTaskDTO(taskRepository.getOne(id));
        taskDTO.setFinishDate(new Date());
        return taskMapper.toTaskDTO(taskRepository.save(taskMapper.toTask(taskDTO)));
    }

    @Override
    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }
}
