package com.example.todo.controller.api.todo

import com.example.todo.controller.api.todo.model.http.TodoDto
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController {

    @GetMapping
    fun read(@RequestParam(required = false) index: Int) {

    }

    @PostMapping
    fun create(@Valid @RequestBody todoDto: TodoDto) {

    }

    @PutMapping
    fun update(@Valid @RequestBody todoDto: TodoDto) {

    }

    @DeleteMapping
    fun create(@PathVariable(name = "index") _index: Int) {

    }
}