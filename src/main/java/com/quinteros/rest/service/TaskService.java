package com.quinteros.rest.service;

import com.quinteros.rest.persistence.entity.Task;
import com.quinteros.rest.persistence.entity.TaskStatus;
import com.quinteros.rest.service.dto.TaskInDto;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskService{

    public Task createTask(TaskInDto taskInDto);

    public List<Task> findAll();

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus);

    @Transactional
    public void updateTaskAsFinished(Long id);

}
