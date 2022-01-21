package com.orangebuddies.orangutan.banner

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import javax.persistence.Entity

@Entity
@Table("nl_banner_new")
data class Banner(
        @Id
        @Column("bannerid")
        val bannerId: Long? = 0,

        @Column("storeid")
        val storeId: Long? = 0,

        @Column("size")
        val type: String? = "",

        @Column("imageurl")
        val imageUrl: String? = "",

        @Column("banner_position")
        val position: String? = "",

        @Column("linkurl")
        val linkUrl: String? = "",

        @Column("culture")
        val culture: String? = "",

        @Column("platform")
        val channel: String? = ""

//        @Column("todate")
//        val dateUntil: LocalDate? = null
//        @Column("todate")
//        val dateUntil: ZonedDateTime
)