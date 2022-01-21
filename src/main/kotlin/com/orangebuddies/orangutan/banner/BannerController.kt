package com.orangebuddies.orangutan.banner

import com.orangebuddies.orangutan.configuration.PartnerConfigs
import com.orangebuddies.orangutan.exception.EmptyValueException
import org.springframework.data.domain.Page
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class BannerController(
        val service: BannerService,
        val partnerConfig: PartnerConfigs,
        private val databaseClient: DatabaseClient
) {
    @GetMapping("/banners")

    // http://localhost:5000/api/banners?culture=en-GB&channel=web&type=SkyScraperWrapper&page=1&limit=2
    suspend fun getBanners(
            @RequestHeader("X-API-KEY") partnerKey: String,
            @RequestParam("culture") culture: String,
            @RequestParam("channel", required = false) channel: String,
            @RequestParam("type", required = false) size: String,
            @RequestParam("page", defaultValue = "1") page: Int,
            @RequestParam("limit", defaultValue = "1") limit: Int
    ): BannerResponse {
        val partner = partnerConfig.partners[partnerKey]?.get("apikey") ?: throw EmptyValueException("Invalid API key")
        //var size: List<String> = type.split(",").map { it.trim('[').trim(']').trim(' ') }
        val banners = service.getBanners(culture, channel, size, limit, page)
        return banners
    }
    @GetMapping("/test")
   suspend fun testFun(): BannerResponse {
     val banners= service.finBannerByClient()
        return banners
    }

}