package com.todo.javatodo.controller;

import com.todo.javatodo.entity.Stat;
import com.todo.javatodo.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class StatController {
    private final StatService statService;

    @PostMapping("/stat")
    public ResponseEntity<Stat> findByEmail(@RequestBody String email) {
        return ResponseEntity.ok(statService.findStat(email));
    }


}
