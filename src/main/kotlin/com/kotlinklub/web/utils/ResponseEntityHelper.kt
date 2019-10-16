package com.kotlinklub.web.utils

import com.kotlinklub.web.beans.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class ResponseEntityHelper {

    fun okResponseEntity(content: Any? = null, key: String? = null): ResponseEntity<*> {

        val response = BaseResponse()

        if (key != null && content != null) {
            val map = mapOf(key to content)
            response.content = map

        } else {

            response.content = content

        }

        response.isSuccess = true
        response.code = HttpStatus.OK.toString()
        return ResponseEntity.ok().body<BaseResponse>(response)
    }

    fun badResponseEntity(message: String): ResponseEntity<*> {

        val response = BaseResponse()
        response.isSuccess = false
        response.message = message
        response.code = HttpStatus.BAD_REQUEST.toString()
        return ResponseEntity.badRequest().body<BaseResponse>(response)
    }
}