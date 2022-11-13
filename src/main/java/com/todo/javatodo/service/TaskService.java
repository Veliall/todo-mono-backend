package com.todo.javatodo.service;

import com.todo.javatodo.entity.Task;
import com.todo.javatodo.exception.TodoException;
import com.todo.javatodo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    @Cacheable(cacheNames = "tasks")
    public List<Task> findAll(String email) {
        return repository.findByUserEmailOrderByTitleAsc(email);
    }

    public Task add(Task task) {
        if (task.getId() != null) {
            throw new TodoException("Field ID must be null for saving");
        }

        if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
            throw new TodoException("Missed param: title");
        }

        return repository.save(task);
    }

    public Task update(Task task) {
        if (task.getId() == null) {
            throw new TodoException("Missed param: id");
        }

        if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
            throw new TodoException("Missed param: title");
        }

        return repository.save(task);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new TodoException(String.format("Task with ID %s doesn't exist",id))
        );
    }
}
