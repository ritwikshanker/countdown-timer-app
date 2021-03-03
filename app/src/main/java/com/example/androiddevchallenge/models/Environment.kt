package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Environment(
    @SerializedName("cats")
    var cats: Boolean?, // true
    @SerializedName("children")
    var children: Boolean?, // false
    @SerializedName("dogs")
    var dogs: Boolean? // true
)