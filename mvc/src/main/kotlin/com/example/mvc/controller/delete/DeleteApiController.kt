package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,
        @RequestParam(value = "age") _age: Int,
    ): String {
        return "$_name $_age"
    }

    @DeleteMapping("/delete-mapping/{name}/{age}")
    fun deleteMappingPath(
        @PathVariable(value = "name") _name: String,
        @PathVariable(value = "age") _age: Int
    ): String {
        return "$_name $_age"
    }
}