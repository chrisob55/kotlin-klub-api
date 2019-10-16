package com.kotlinklub.core.services

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlinklub.core.dao.AndroidRatingRepository
import com.kotlinklub.core.domain.AndroidRating
import com.kotlinklub.core.domain.PlayStoreRating
import com.kotlinklub.core.domain.PlayStoreResponse
import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayStoreServiceImpl: PlayStoreService {

    override fun latestRating(): PlayStoreRating {

        val doc = Jsoup.connect("https://play.google.com/store/apps/details?id=uk.gov.hmrc.ptcalc").timeout(10000).get()
        val scripts = doc.select("script")

        val result = scripts.first {it.attr("type").contentEquals("application/ld+json")}

        val mapper = ObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        val rating = mapper.readValue(result.data(), PlayStoreResponse::class.java)
        return PlayStoreRating(rating = rating.aggregateRating.ratingValue)
    }
}