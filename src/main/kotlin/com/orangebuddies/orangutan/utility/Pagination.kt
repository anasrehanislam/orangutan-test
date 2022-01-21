package com.orangebuddies.orangutan.utility

import com.google.gson.annotations.SerializedName

class Pagination(
        @SerializedName("page") var page: Int,
        @SerializedName("limit") var limit: Int,
        @SerializedName("total") var total: Int,
        @SerializedName("pageCount") var pageCount: Int = 1
) {
    fun setOffset(): Int {
        return (this.page - 1) * this.limit;
    }
    fun setPageCount() {
        val ceilVal = (this.total / this.limit).toDouble()
        this.pageCount = Math.ceil(ceilVal).toInt()
        // This statement can be removed
        if (this.pageCount == 0)
            this.pageCount = 1
    }
}