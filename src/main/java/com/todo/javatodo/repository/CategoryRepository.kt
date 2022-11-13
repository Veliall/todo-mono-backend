package com.todo.javatodo.repository

import com.todo.javatodo.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {
    fun findByUserEmailOrderByTitleAsc(email: String): List<Category>
}