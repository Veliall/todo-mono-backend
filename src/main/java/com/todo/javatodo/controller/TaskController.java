package com.todo.javatodo.controller;

import com.todo.javatodo.entity.Task;
import com.todo.javatodo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/all")
    public ResponseEntity<List<Task>> findAll(@RequestBody String email) {
        return ResponseEntity.ok(taskService.findAll(email));
    }

    @PostMapping("/add")
    public ResponseEntity<Task> add(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.add(task));
    }


    @PutMapping("/update")
    public ResponseEntity<Task> update(@RequestBody Task task) {
        taskService.update(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/id")
    public ResponseEntity<Task> findById(@RequestBody Long id) {
        Task task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }
}
