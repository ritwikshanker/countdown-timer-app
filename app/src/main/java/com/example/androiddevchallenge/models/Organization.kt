package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Organization(
    @SerializedName("href")
    var href: String? // /v2/organizations/nj333
)