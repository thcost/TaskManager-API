package com.thiagofonseca.taskmanager.controller;

import com.thiagofonseca.taskmanager.model.Task;
import com.thiagofonseca.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService service;


    public TaskController(TaskService service) {
        this.service = service;
    }


    @GetMapping
    public List<Task> findAll() {
        return service.findAll();
    }


    @PostMapping
    public Task create(@Valid @RequestBody Task task) {
        return service.save(task);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
