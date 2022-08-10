package com.example.todo.repository

import com.example.todo.config.AppConfig
import com.example.todo.database.Todo
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest(classes = [TodoRepositoryImpl::class, AppConfig::class])
class TodoRepositoryTest {

    @Autowired
    lateinit var todoRepositoryImpl: TodoRepositoryImpl

    @BeforeEach
    fun before() {
        todoRepositoryImpl.todoDataBase.init()
    }

    @Test
    fun saveTest() {
        val todo = Todo().apply {
            this.title = "foo"
            this.description = "bar"
            this.schedule = LocalDateTime.now()
        }

        val result = todoRepositoryImpl.save(todo)
        assertThat(result?.index).isEqualTo(1)
        assertThat(result?.createdAt).isNotNull
        assertThat(result?.updatedAt).isNotNull
        assertThat(result?.title).isEqualTo("foo")
        assertThat(result?.description).isEqualTo("bar")
    }

    @Test
    fun saveAllTest() {
        val todoList = mutableListOf(
            Todo().apply {
                this.title = "foo"
                this.description = "bar"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply {
                this.title = "foo"
                this.description = "bar"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply {
                this.title = "foo"
                this.description = "bar"
                this.schedule = LocalDateTime.now()
            }
        )

        val result = todoRepositoryImpl.saveAll(todoList)

        assertThat(result).isTrue
    }

    @Test
    fun findOneTest() {
        val todoList = mutableListOf(
            Todo().apply {
                this.title = "foo1"
                this.description = "bar1"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply {
                this.title = "foo2"
                this.description = "bar2"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply {
                this.title = "foo3"
                this.description = "bar3"
                this.schedule = LocalDateTime.now()
            }
        )

        todoRepositoryImpl.saveAll(todoList)

        val result = todoRepositoryImpl.findOne(2)

        assertThat(result).isNotNull
        assertThat(result.title).isEqualTo("foo2")
        assertThat(result.description).isEqualTo("bar2")
    }

    @Test
    fun updateTest() {
        val todo = Todo().apply {
            this.title = "foo"
            this.description = "bar"
            this.schedule = LocalDateTime.now()
        }

        val insertTodo = todoRepositoryImpl.save(todo)

        val newTodo = Todo().apply {
            this.index = insertTodo?.index
            this.title = "updated foo"
            this.description = "updated bar"
            this.schedule = LocalDateTime.now()
        }

        val result = todoRepositoryImpl.save(newTodo)

        assertThat(result).isNotNull
        assertThat(result?.index).isEqualTo(insertTodo?.index)
        assertThat(result?.title).isEqualTo("updated foo")
        assertThat(result?.description).isEqualTo("updated bar")

    }

}