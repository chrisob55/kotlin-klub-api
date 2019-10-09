package com.kotlinklub.web.controllers

import com.kotlinklub.core.services.AndroidRatingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/android_ratings")
class AndroidRatingController {

    @Autowired
    lateinit var ratingService: AndroidRatingService

    @RequestMapping(method = [RequestMethod.GET], value = "")
    fun findAll(): ResponseEntity<*> {
        val map = HashMap<String, Any>()
        map.put("users", ratingService.findAll())
        return ResponseEntity.ok().body<Any>(map)
    }

    @RequestMapping(method = [RequestMethod.GET], value = "/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<*> {
        ratingService.find(id)?.let{rating ->
            return ResponseEntity.ok().body<Any>(rating)
        } ?: run{
            return ResponseEntity.badRequest().body<Any>("Not found")
        }
    }
}