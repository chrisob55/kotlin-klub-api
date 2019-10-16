package com.kotlinklub.core.domain

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*
import javax.persistence.*

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class AndroidRating (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false)
        var date: Date,

        @Column(nullable = false)
        var rating: Double
)