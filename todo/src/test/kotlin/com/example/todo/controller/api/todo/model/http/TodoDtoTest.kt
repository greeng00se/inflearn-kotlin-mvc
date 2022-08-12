package com.example.todo.controller.api.todo.model.http

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.validation.FieldError
import javax.validation.Validation

class TodoDtoTest {
    private val validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun todoDtoTest() {
        val todoDto = TodoDto().apply {
            this.title = "foo"
            this.description = "bar"
            this.schedule = "2020-10-20 13:00:00"
        }

        val result = validator.validate(todoDto)

        assertThat(result.isEmpty()).isTrue
    }
}