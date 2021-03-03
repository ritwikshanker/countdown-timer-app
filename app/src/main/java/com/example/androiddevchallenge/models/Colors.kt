package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Colors(
    @SerializedName("primary")
    var primary: String?, // Tortoiseshell
    @SerializedName("secondary")
    var secondary: Any?, // null
    @SerializedName("tertiary")
    var tertiary: Any? // null
)