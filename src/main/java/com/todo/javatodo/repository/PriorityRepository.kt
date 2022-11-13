package com.todo.javatodo.repository

import com.todo.javatodo.entity.Priority
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PriorityRepository : JpaRepository<Priority, Long> {
    fun findByUserEmailOrderByIdAsc(email: String): List<Priority>
}