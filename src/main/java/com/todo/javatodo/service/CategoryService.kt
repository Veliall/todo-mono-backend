package com.todo.javatodo.service

import com.todo.javatodo.entity.Category
import com.todo.javatodo.exception.TodoException
import com.todo.javatodo.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun findByUserEmail(email: String): List<Category> {
        return categoryRepository.findByUserEmailOrderByTitleAsc(email)
    }

    fun save(category: Category): Category {
        if (category.id != null) {
            throw TodoException("Field ID must be null for saving new Category")
        }
        if (category.title == null || category.title.trim { it <= ' ' }.isEmpty()) {
            throw TodoException("Field Title shouldn't be empty")
        }
        return categoryRepository.save(category)
    }

    fun update(category: Category): Category {
        if (category.id == null) {
            throw TodoException("Field ID can't be null for updating new Category")
        }
        if (category.title == null || category.title.trim { it <= ' ' }.isEmpty()) {
            throw TodoException("Field Title shouldn't be empty")
        }
        return categoryRepository.save(category)
    }

    fun delete(id: Long) {
        categoryRepository.deleteById(id)
    }
}