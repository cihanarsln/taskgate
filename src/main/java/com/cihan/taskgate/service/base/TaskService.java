package com.cihan.taskgate.service.base;

import com.cihan.taskgate.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskService {

    TaskDTO save(TaskDTO taskDTO);

    TaskDTO findById(long id);

    List<TaskDTO> findAll();

    void deleteById(long id);

}
