package com.kotlinklub.core.domain

class PlayStoreResponse() {

    lateinit var operatingSystem: String
    lateinit var aggregateRating: AggregateRating

    class AggregateRating {
        var ratingValue = 0.0
    }
}