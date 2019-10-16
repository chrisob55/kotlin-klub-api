package com.kotlinklub.core.services

import com.kotlinklub.core.domain.PlayStoreRating

interface PlayStoreService {
    fun latestRating(): PlayStoreRating
}