package com.thiagofonseca.taskmanager.service;

import com.thiagofonseca.taskmanager.model.Task;
import com.thiagofonseca.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Task update(Long id, Task task) {

    Task existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

    existing.setTitle(task.getTitle());
    existing.setCompleted(task.isCompleted());

    return repository.save(existing);
    }
}

