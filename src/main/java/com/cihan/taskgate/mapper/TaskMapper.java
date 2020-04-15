package com.cihan.taskgate.mapper;

import com.cihan.taskgate.dto.TaskDTO;
import com.cihan.taskgate.model.Task;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Named("toTask")
    Task toTask(TaskDTO taskDTO);

    @Named("toTaskDTO")
    TaskDTO toTaskDTO(Task task);

    @IterableMapping(qualifiedByName = "toTask")
    List<Task> toTaskList(List<TaskDTO> taskDTOList);

    @IterableMapping(qualifiedByName = "toTaskDTO")
    List<TaskDTO> totaskDTOList(List<Task> taskList);

}
