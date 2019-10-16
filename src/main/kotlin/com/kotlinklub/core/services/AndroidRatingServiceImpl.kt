package com.kotlinklub.core.services

import com.kotlinklub.core.dao.AndroidRatingRepository
import com.kotlinklub.core.domain.AndroidRating
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AndroidRatingServiceImpl: AndroidRatingService {

    @Autowired
    lateinit var androidRatingRepository: AndroidRatingRepository

    override fun create(date: Date, rating: Double): AndroidRating {
        val androidRating = AndroidRating(date = date, rating = rating)
        androidRatingRepository.save(androidRating)
        return androidRating
    }

    override fun find(id: Long): AndroidRating? {
        return androidRatingRepository.findById(id).orElse(null)
    }

    override fun findAll(): List<AndroidRating> {
        return androidRatingRepository.findAll()
    }
}