package com.todo.javatodo.controller;

import com.todo.javatodo.entity.Priority;
import com.todo.javatodo.service.PriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/priority")
@RequiredArgsConstructor
public class PriorityController {

    private PriorityService priorityService;


    @PostMapping("/all")
    public List<Priority> findAll(@RequestBody String email) {
        return priorityService.findAll(email);
    }


    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody Priority priority) {

        return ResponseEntity.ok(priorityService.add(priority));
    }


    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Priority priority) {
        priorityService.update(priority);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id) {

        Priority priority = priorityService.findById(id);

        return ResponseEntity.ok(priority);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        priorityService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
