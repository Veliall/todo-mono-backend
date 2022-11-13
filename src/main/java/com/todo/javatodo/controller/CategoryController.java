package com.todo.javatodo.controller;

import com.todo.javatodo.entity.Category;
import com.todo.javatodo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/all")
    public List<Category> findById(@RequestBody String userEmail) {
        return categoryService.findByUserEmail(userEmail);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> save(@RequestBody Category category) {
        Category cat = categoryService.save(category);
        return ResponseEntity.ok(cat);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category) {
        Category cat = categoryService.update(category);
        return ResponseEntity.ok(cat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
