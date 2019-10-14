package com.kotlinklub.web.controllers

import com.kotlinklub.core.resources.PostResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/posts")
class PostController {

    @Autowired
    lateinit var resource: PostResource

    @RequestMapping(method = [RequestMethod.GET])
    fun posts(): ResponseEntity<Any> {
        val map = HashMap<String, Any>()
        map.put("posts", resource.posts())
        return ResponseEntity.ok().body<Any>(map)
    }
}