package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Pagination(
    @SerializedName("count_per_page")
    var countPerPage: Int?, // 20
    @SerializedName("current_page")
    var currentPage: Int?, // 1
    @SerializedName("_links")
    var links: LinksX?,
    @SerializedName("total_count")
    var totalCount: Int?, // 320
    @SerializedName("total_pages")
    var totalPages: Int? // 16
)