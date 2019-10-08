package com.kotlinklub.web.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RootController {

    @RequestMapping(method = [RequestMethod.GET], value = "/version")
    fun version(): String {
        return "Version 1.0 live"
    }
}