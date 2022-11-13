package com.todo.javatodo.service;

import com.todo.javatodo.entity.Stat;
import com.todo.javatodo.repository.StatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatService {

    private final StatRepository repository;

    public Stat findStat(String email) {
        return repository.findByUserEmail(email);
    }

}
