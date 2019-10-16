package com.kotlinklub.web.beans

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class BaseResponse {

    var code: String? = null
    var message: String? = null
    var isSuccess: Boolean = false
    var content: Any? = null
}
