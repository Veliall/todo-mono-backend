package com.todo.javatodo.service

import com.todo.javatodo.entity.Task
import com.todo.javatodo.exception.TodoException
import com.todo.javatodo.repository.TaskRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class TaskService(private val repository: TaskRepository) {

    @Cacheable(cacheNames = ["tasks"])
    fun findAll(email: String): List<Task> {
        return repository.findByUserEmailOrderByTitleAsc(email)
    }

    fun add(task: Task): Task {
        if (task.id != null) {
            throw TodoException("Field ID must be null for saving")
        }
        if (task.title == null || task.title.trim { it <= ' ' }.isEmpty()) {
            throw TodoException("Missed param: title")
        }
        return repository.save(task)
    }

    fun update(task: Task): Task {
        if (task.id == null) {
            throw TodoException("Missed param: id")
        }
        if (task.title == null || task.title.trim { it <= ' ' }.isEmpty()) {
            throw TodoException("Missed param: title")
        }
        return repository.save(task)
    }

    fun deleteById(id: Long) {
        repository.deleteById(id)
    }

    fun findById(id: Long): Task {
        return repository.findById(id).orElseThrow { TodoException(String.format("Task with ID %s doesn't exist", id)) }
    }
}