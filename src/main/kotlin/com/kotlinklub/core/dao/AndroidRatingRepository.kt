package com.kotlinklub.core.dao

import com.kotlinklub.core.domain.AndroidRating
import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

@Transactional(Transactional.TxType.MANDATORY)
interface AndroidRatingRepository : JpaRepository<AndroidRating, Long> {
}