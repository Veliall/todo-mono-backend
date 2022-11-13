package com.todo.javatodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JavaTodoApplication

fun main(args: Array<String>) {
    runApplication<JavaTodoApplication>(*args)
}
