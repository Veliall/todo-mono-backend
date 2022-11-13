package com.todo.javatodo.service;

import com.todo.javatodo.entity.Category;
import com.todo.javatodo.exception.TodoException;
import com.todo.javatodo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findByUserEmail(String email) {
        return categoryRepository.findByUserEmailOrderByTitleAsc(email);
    }

    public Category save(Category category) {
        if (category.getId() != null) {
            throw new TodoException("Field ID must be null for saving new Category");
        }

        if (category.getTitle() == null || category.getTitle().trim().length() == 0) {
            throw new TodoException("Field Title shouldn't be empty");
        }
        return categoryRepository.save(category);
    }
}
