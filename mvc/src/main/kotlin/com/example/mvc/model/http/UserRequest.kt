package com.example.mvc.model.http

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

data class UserRequest(
    @field:NotEmpty()
    @field:Size(min = 2, max = 8)
    var name: String? = null,

    @field:PositiveOrZero // 0 <
    var age: Int? = null,

    @field:Email
    var email: String? = null,

    @field:NotBlank
    var address: String? = null,

//    @JsonProperty("phone_number")
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") // regexp
    var phoneNumber: String? = null,

    var createdAt: String? = null
) {

    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다.")
    private fun isValidCreateAt(): Boolean = try {
        LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        true
    } catch (e:Exception) {
        false
    }
}