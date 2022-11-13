package com.todo.javatodo.controller

import com.todo.javatodo.exception.TodoException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionController {
    @ExceptionHandler(TodoException::class)
    fun handleAppError(ex: Exception): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(ex.message)
    }
}