package com.orangebuddies.orangutan.mappers

import com.orangebuddies.orangutan.banner.Banner
import io.r2dbc.spi.Row
import org.springframework.stereotype.Component
import java.util.function.BiFunction

@Component
class BannerMapper: BiFunction<Row, Any, Banner> {
    override fun apply(row: Row, o: Any): Banner {
        return Banner(
                row.get("bannerid", Long::class.java) ?: 0,
                row.get("storeid", Long::class.java) ?: 0,
                row.get("size", String::class.java) ?: "",
                row.get("imageurl", String::class.java) ?: "",
                row.get("banner_position", String::class.java) ?: "",
                row.get("linkUrl", String::class.java) ?: "",
                row.get("culture", String::class.java) ?: null
        )
    }
}