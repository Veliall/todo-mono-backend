package com.todo.javatodo.repository

import com.todo.javatodo.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task, Long> {
    fun findByUserEmailOrderByTitleAsc(email: String): List<Task>
}