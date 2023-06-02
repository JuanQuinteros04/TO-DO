package com.quinteros.rest.service;


import com.quinteros.rest.exceptions.ToDoExceptions;
import com.quinteros.rest.mapper.TaskMapper;
import com.quinteros.rest.persistence.entity.Task;
import com.quinteros.rest.persistence.entity.TaskStatus;
import com.quinteros.rest.persistence.repository.TaskRepository;
import com.quinteros.rest.service.dto.TaskInDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl  implements TaskService {

    private final TaskRepository taskRepository;

    TaskMapper taskMapper =TaskMapper.INSTANCE;

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
       Optional<Task> optionalTask = this.taskRepository.findById(id);
       if(optionalTask.isEmpty()){
           throw new ToDoExceptions("Task Not Found", HttpStatus.NOT_FOUND);
       }
        taskRepository.markTaskAsFinished(id);
    }


}
