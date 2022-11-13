package com.todo.javatodo.controller;

import com.todo.javatodo.entity.Category;
import com.todo.javatodo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
