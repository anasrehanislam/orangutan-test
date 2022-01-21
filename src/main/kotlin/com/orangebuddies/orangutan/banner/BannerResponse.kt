package com.orangebuddies.orangutan.banner
import com.google.gson.annotations.SerializedName
import com.orangebuddies.orangutan.utility.Pagination
import reactor.core.publisher.Flux

data class BannerResponse(
        @SerializedName("pagination") var pagination: Pagination?,
        @SerializedName("banners") var banners: List<Banner>?= listOf()
)

data class BannerResponse2(
        @SerializedName("pagination") var pagination: Pagination?,
        @SerializedName("banners") var banners: Flux<Banner>?
)