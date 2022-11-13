package com.todo.javatodo.controller

import com.todo.javatodo.entity.Category
import com.todo.javatodo.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/category")
class CategoryController(private val categoryService: CategoryService) {

    @PostMapping("/all")
    fun findById(@RequestBody userEmail: String): List<Category> {
        return categoryService.findByUserEmail(userEmail)
    }

    @PostMapping("/add")
    fun save(@RequestBody category: Category): ResponseEntity<Category> {
        val cat = categoryService.save(category)
        return ResponseEntity.ok(cat)
    }

    @PutMapping("/update")
    fun update(@RequestBody category: Category): ResponseEntity<Category> {
        val cat = categoryService.update(category)
        return ResponseEntity.ok(cat)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Category> {
        categoryService.delete(id)
        return ResponseEntity.ok().build()
    }
}