package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Self(
    @SerializedName("href")
    var href: String? // /v2/animals/124
)