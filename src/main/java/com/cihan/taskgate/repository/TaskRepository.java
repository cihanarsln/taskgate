package com.cihan.taskgate.repository;

import com.cihan.taskgate.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByMember_Username(String username);

    List<Task> findAllByMember_Id(long id);
}
