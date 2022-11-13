package com.todo.javatodo.service;

import com.todo.javatodo.entity.Priority;
import com.todo.javatodo.exception.TodoException;
import com.todo.javatodo.repository.PriorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriorityService {

    private final PriorityRepository repository;


    public List<Priority> findAll(String email) {
        return repository.findByUserEmailOrderByIdAsc(email);
    }

    public Priority add(Priority priority) {
        if (priority.getId() != null) {
            throw new TodoException("Field ID must be null for saving");
        }

        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            throw new TodoException("Missed param: title");
        }

        if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
            throw new TodoException("Missed param: color");
        }
        return repository.save(priority);
    }

    public Priority update(Priority priority) {
        if (priority.getId() == null) {
            throw new TodoException("Missed param: id");
        }

        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            throw new TodoException("Missed param: title");
        }

        if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
            throw new TodoException("Missed param: color");
        }
        return repository.save(priority);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Priority findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new TodoException(String.format("Priority with ID %s doesn't exist",id))
        );
    }

}
