package com.todo.javatodo.controller

import com.todo.javatodo.entity.Stat
import com.todo.javatodo.service.StatService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StatController(private val statService: StatService) {
    @PostMapping("/stat")
    fun findByEmail(@RequestBody email: String): ResponseEntity<Stat> {
        return ResponseEntity.ok(statService.findStat(email))
    }
}