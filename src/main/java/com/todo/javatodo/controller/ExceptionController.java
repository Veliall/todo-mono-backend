package com.todo.javatodo.controller;

import com.todo.javatodo.exception.TodoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler({TodoException.class})
    public ResponseEntity<Object> handleAppError(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}
