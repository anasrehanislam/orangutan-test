package com.orangebuddies.orangutan.banner

import com.orangebuddies.orangutan.mappers.BannerMapper
import com.orangebuddies.orangutan.utility.Pagination
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.awaitFirstOrDefault
import org.springframework.data.domain.*
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class BannerService(
        private val bannerRepository: BannerRepository,
        private val databaseClient: DatabaseClient,
        private val mapper: BannerMapper,
) {
    suspend fun getBanners(culture: String, channel: String, size: String, limit: Int, page: Int): BannerResponse {
        val total = bannerRepository.findBannersCount(culture, channel, size)
        val pagination: Pagination = Pagination(page, limit, total.awaitFirstOrDefault(1))
        pagination.setPageCount()
        val offset = pagination.setOffset();
        val banners: List<Banner> = bannerRepository.findBanners(culture, channel, size, limit, offset)
        return BannerResponse(pagination, banners)
    }
   suspend fun finBannerByClient(): BannerResponse {
       val banners = bannerRepository.findByCulture("en-GB",PageRequest.of(1,3)).toList()
       println(banners)
       return BannerResponse(null, banners)
//        return databaseClient.sql("SELECT * from nl_banner_new  WHERE culture = :culture AND channel = :channel")
//                .bind("culture", "en-GB")
//                .bind("channel", "web")
//                .map(mapper::apply)
//                .all()
    }

//    suspend fun findBannersByCulturePage(): Flux<Banner> {
//        val sort = Sort.by("bannerId").descending()
//        val page = bannerRepository.findByCultureContainingIgnoreCase("en-GB", PageRequest.of(1, 2))
//        val banners: List<Banner> = bannerRepository.findByCulture("en-GB", sort)
//        return page
//    }

//    fun findBannersByCulture(): Mono<Page<Banner?>?>? {
//        return this.bannerRepository.findByCultureContainingIgnoreCase("en-GB" ,  PageRequest.of(1, 2))
//                .collectList()
//                .zipWith(this.bannerRepository.count())
//                .map { t -> PageImpl(t.getT1(), PageRequest.of(1, 2)!!, t.getT2()) }
//    }

    //    fun findBannerByExample(): Flux<Banner> {
//        val banner = Banner(null, null, null, null, null, null, null)
//        val example: Example<Banner> = Example.of(banner)
//        val employees: Flux<Banner> = bannerRepository.findAll(example)
//        return employees
//
//    }

}