package com.kotlinklub.core.services

import com.kotlinklub.core.domain.AndroidRating
import java.util.*

interface AndroidRatingService {
    fun create(date: Date, rating: Double): AndroidRating
    fun find(id: Long): AndroidRating?
    fun findAll(): List<AndroidRating>
}