package com.kotlinklub.core.resources

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
interface PostResource {

    @RequestMapping(method = [RequestMethod.GET], value = "/posts")
    fun posts(): List<Post>

    @RequestMapping(method = [RequestMethod.GET], value = "/posts/{postId}", produces = ["application/json"])
    fun getPostById(@PathVariable("postId") postId: Long?): Post
}