package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Breeds(
    @SerializedName("mixed")
    var mixed: Boolean?, // false
    @SerializedName("primary")
    var primary: String?, // American Shorthair
    @SerializedName("secondary")
    var secondary: Any?, // null
    @SerializedName("unknown")
    var unknown: Boolean? // false
)