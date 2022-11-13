package com.todo.javatodo.service

import com.todo.javatodo.entity.Priority
import com.todo.javatodo.exception.TodoException
import com.todo.javatodo.repository.PriorityRepository
import org.springframework.stereotype.Service

@Service
class PriorityService(private val repository: PriorityRepository) {

    fun findAll(email: String): List<Priority> {
        return repository.findByUserEmailOrderByIdAsc(email)
    }

    fun add(priority: Priority): Priority {
        if (priority.id != null) {
            throw TodoException("Field ID must be null for saving")
        }
        if (priority.title == null || priority.title.trim { it <= ' ' }.isEmpty()) {
            throw TodoException("Missed param: title")
        }
        if (priority.color == null || priority.color.trim { it <= ' ' }.isEmpty()) {
            throw TodoException("Missed param: color")
        }
        return repository.save(priority)
    }

    fun update(priority: Priority): Priority {
        if (priority.id == null) {
            throw TodoException("Missed param: id")
        }
        if (priority.title == null || priority.title.trim { it <= ' ' }.isEmpty()) {
            throw TodoException("Missed param: title")
        }
        if (priority.color == null || priority.color.trim { it <= ' ' }.isEmpty()) {
            throw TodoException("Missed param: color")
        }
        return repository.save(priority)
    }

    fun deleteById(id: Long) {
        repository.deleteById(id)
    }

    fun findById(id: Long): Priority {
        return repository.findById(id).orElseThrow { TodoException("Priority with ID $id doesn't exist") }
    }
}