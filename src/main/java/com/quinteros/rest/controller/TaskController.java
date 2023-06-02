package com.quinteros.rest.controller;

import com.quinteros.rest.persistence.entity.Task;
import com.quinteros.rest.persistence.entity.TaskStatus;
import com.quinteros.rest.service.TaskServiceImpl;
import com.quinteros.rest.service.dto.TaskInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;

    public TaskController(TaskServiceImpl taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }


    @PostMapping
    public Task createTask(@RequestBody TaskInDto taskInDto) {
        return this.taskServiceImpl.createTask(taskInDto);
    }


    @GetMapping
    public List<Task> findAll(){
        return taskServiceImpl.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status")TaskStatus status){

        return this.taskServiceImpl.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        this.taskServiceImpl.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

}
