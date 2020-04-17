package com.cihan.taskgate.service.base;

import com.cihan.taskgate.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskService {

    TaskDTO save(TaskDTO taskDTO);

    TaskDTO findById(long id);

    List<TaskDTO> findAll();

    List<TaskDTO> findAllByMember_Username(String username);

    List<TaskDTO> findAllByMember_Id(long id);

    TaskDTO finishTask(long id);

    void deleteById(long id);

}
