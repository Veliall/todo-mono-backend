package com.todo.javatodo.repository

import com.todo.javatodo.entity.Stat
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StatRepository : CrudRepository<Stat, Long> {
    fun findByUserEmail(email: String): Stat
}