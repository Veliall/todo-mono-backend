package com.todo.javatodo.service

import com.todo.javatodo.entity.Stat
import com.todo.javatodo.repository.StatRepository
import org.springframework.stereotype.Service

@Service
class StatService(private val repository: StatRepository) {
    fun findStat(email: String): Stat {
        return repository.findByUserEmail(email)
    }
}