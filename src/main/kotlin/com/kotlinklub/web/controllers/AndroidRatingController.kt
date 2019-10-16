package com.kotlinklub.web.controllers

import com.kotlinklub.core.services.AndroidRatingService
import com.kotlinklub.web.utils.ResponseEntityHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/android_ratings")
class AndroidRatingController {

    @Autowired
    lateinit var ratingService: AndroidRatingService

    @Autowired
    lateinit var responseEntityHelper: ResponseEntityHelper

    @RequestMapping(method = [RequestMethod.GET], value = "")
    fun findAll(): ResponseEntity<*> {
        return responseEntityHelper.okResponseEntity(ratingService.findAll(), "ratings")
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