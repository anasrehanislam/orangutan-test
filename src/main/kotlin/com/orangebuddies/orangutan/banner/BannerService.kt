package com.orangebuddies.orangutan.banner

import com.orangebuddies.orangutan.utility.Pagination
import kotlinx.coroutines.reactive.awaitFirstOrDefault
import org.springframework.stereotype.Service

@Service
class BannerService(
        private val bannerRepository: BannerRepository
) {
    suspend fun getBanners(culture: String, channel: String, size: String, limit: Int, page: Int): BannerResponse {
        val total = bannerRepository.findBannersCount(culture, channel, size)
        val pagination: Pagination = Pagination(page, limit, total.awaitFirstOrDefault(1))
        pagination.setPageCount()
        val offset = pagination.setOffset();
        val banners: List<Banner> = bannerRepository.findBanners(culture, channel, size, limit, offset)
        return BannerResponse(pagination, banners)
    }

}