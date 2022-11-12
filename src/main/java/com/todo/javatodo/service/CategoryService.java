package com.todo.javatodo.service;

import com.todo.javatodo.entity.Category;
import com.todo.javatodo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format(
                        "Category with id %s doesn't exist", id
                ))
        );
    }
}
