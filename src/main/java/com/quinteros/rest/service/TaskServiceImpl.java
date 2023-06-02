package com.quinteros.rest.service;


import com.quinteros.rest.exceptions.NotFoundException;
import com.quinteros.rest.mapper.TaskMapper;
import com.quinteros.rest.persistence.entity.Task;
import com.quinteros.rest.persistence.entity.TaskStatus;
import com.quinteros.rest.persistence.repository.TaskRepository;
import com.quinteros.rest.service.dto.TaskInDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl  implements TaskService {

    private final TaskRepository taskRepository;

    TaskMapper taskMapper = TaskMapper.INSTANCE;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(TaskInDto taskInDto) {
        Task task = taskMapper.taskInDtoToTask(taskInDto);
        task.setTaskStatus(TaskStatus.ON_TIME);
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        taskRepository.save(task);
        return null;
    }

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Override
    public List<Task> findAllByTaskStatus(TaskStatus taskStatus) {
        return taskRepository.findAllByTaskStatus(taskStatus);
    }

    @Override
    @Transactional
    public void updateTaskAsFinished(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(NotFoundException::new);
        task.setFinished(true);
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(NotFoundException::new);
        taskRepository.delete(task);
    }
}

