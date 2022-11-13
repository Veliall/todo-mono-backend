package com.todo.javatodo.controller

import com.todo.javatodo.entity.Priority
import com.todo.javatodo.service.PriorityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/priority")
class PriorityController(private val priorityService: PriorityService) {
    @PostMapping("/all")
    fun findAll(@RequestBody email: String): List<Priority> {
        return priorityService.findAll(email)
    }

    @PostMapping("/add")
    fun add(@RequestBody priority: Priority): ResponseEntity<Priority> {
        return ResponseEntity.ok(priorityService.add(priority))
    }

    @PutMapping("/update")
    fun update(@RequestBody priority: Priority): ResponseEntity<*> {
        priorityService.update(priority)
        return ResponseEntity.ok().build<Any>()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Priority> {
        val priority = priorityService.findById(id)
        return ResponseEntity.ok(priority)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<*> {
        priorityService.deleteById(id)
        return ResponseEntity.ok().build<Any>()
    }
}