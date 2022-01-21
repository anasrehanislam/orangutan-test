package com.orangebuddies.orangutan.banner

import kotlinx.coroutines.flow.Flow
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface BannerRepository : CoroutineCrudRepository<Banner, Long> {

    @Query("SELECT COUNT(*) FROM nl_banner_new b  " +
            " WHERE b.culture= :culture " +
            " AND " +
            " ( :channel is null or b.platform= :channel) " +
            " AND " +
            " ( :size is null or b.size= :size) ")
    fun findBannersCount(culture: String, channel: String?, size: String?): Mono<Int>

    @Query("SELECT * FROM nl_banner_new b  " +
            " WHERE b.culture= :culture " +
            " AND " +
            " ( :channel is null or b.platform= :channel) " +
            " AND " +
            " ( :size is null or b.size= :size) " +
            " LIMIT :limit OFFSET :offset ")
    suspend fun findBanners(culture: String, channel: String?, size: String?, limit: Int, offset: Int): List<Banner>

    //suspend fun findByCulture(culture: String , sort:Sort):List<Banner>
    //fun findByCultureContainingIgnoreCase(culture: String?, page: Pageable): Flux<Banner>
    fun findByCulture(culture: String, page: Pageable): Flow<Banner>

}