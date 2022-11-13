package com.todo.javatodo.controller

import com.todo.javatodo.entity.Task
import com.todo.javatodo.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task")
class TaskController(private val taskService: TaskService) {
    @PostMapping("/all")
    fun findAll(@RequestBody email: String): ResponseEntity<List<Task>> {
        return ResponseEntity.ok(taskService.findAll(email))
    }

    @PostMapping("/add")
    fun add(@RequestBody task: Task): ResponseEntity<Task> {
        return ResponseEntity.ok(taskService.add(task))
    }

    @PutMapping("/update")
    fun update(@RequestBody task: Task): ResponseEntity<Task> {
        taskService.update(task)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<*> {
        taskService.deleteById(id)
        return ResponseEntity.ok().build<Any>()
    }

    @PostMapping("/id")
    fun findById(@RequestBody id: Long): ResponseEntity<Task> {
        val task = taskService.findById(id)
        return ResponseEntity.ok(task)
    }
}