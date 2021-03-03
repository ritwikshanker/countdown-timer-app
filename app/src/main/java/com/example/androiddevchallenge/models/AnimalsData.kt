package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class AnimalsData(
    @SerializedName("animals")
    var animals: List<Animal>?,
    @SerializedName("pagination")
    var pagination: Pagination?
)