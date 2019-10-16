package com.kotlinklub.web.controllers

import com.kotlinklub.core.services.AndroidRatingService
import com.kotlinklub.core.services.PlayStoreService
import com.kotlinklub.web.utils.ResponseEntityHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/jobs")
class JobsController {

    @Autowired
    lateinit var ratingService: AndroidRatingService

    @Autowired
    lateinit var playStoreService: PlayStoreService

    @Autowired
    lateinit var responseEntityHelper: ResponseEntityHelper

    @RequestMapping(method = [RequestMethod.GET], value = "/android_rating")
    fun latestRating(): ResponseEntity<*> {
        val playRating = playStoreService.latestRating()
        val androidRating = ratingService.create(Date(), playRating.rating)
        return responseEntityHelper.okResponseEntity(androidRating, "rating")
    }
}