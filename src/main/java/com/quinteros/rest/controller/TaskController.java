package com.quinteros.rest.controller;

import com.quinteros.rest.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
//    @Autowired
//    private TodoRepository todoRepository;

    @GetMapping(value = "/")
    public String holaMundo() {
        return "HOLA MUNDO!!!";
    }

//    @GetMapping(value = "/tasks")
//    public List<Task> getTasks(){
//        return todoRepository.findAll();
//    }

//    @PostMapping(value = "/savetask")
//    public Task saveTask(RequestBody){
//        todoRepository.save(task);
//        return "Saved task";
//    }
}
