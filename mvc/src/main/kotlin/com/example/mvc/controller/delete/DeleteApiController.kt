package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,
        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message=  "age는 20보다 커야 합니다.")
        @RequestParam(value = "age") _age: Int,
    ): String {
        return "$_name $_age"
    }

    @DeleteMapping("/delete-mapping/{name}/{age}")
    fun deleteMappingPath(
        @NotNull
        @Size(min = 2, max = 5, message = "최소 2자리 최대 5자리이어야 합니다.")
        @PathVariable(value = "name") _name: String,
        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message=  "age는 20보다 커야 합니다.")
        @PathVariable(value = "age") _age: Int
    ): String {
        return "$_name $_age"
    }
}
