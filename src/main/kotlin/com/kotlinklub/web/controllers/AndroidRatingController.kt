package com.kotlinklub.web.controllers

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.util.JSONPObject
import com.kotlinklub.core.domain.PlayStoreResponse
import com.kotlinklub.core.services.AndroidRatingService
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
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

        val doc = Jsoup.connect("https://play.google.com/store/apps/details?id=uk.gov.hmrc.ptcalc").timeout(10000).get()
        val scripts = doc.select("script")

        val result = scripts.first {it.attr("type").contentEquals("application/ld+json")}

        val mapper = ObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        val rating = mapper.readValue(result.data(), PlayStoreResponse::class.java)

        return ResponseEntity.ok().body<Any>(rating)

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