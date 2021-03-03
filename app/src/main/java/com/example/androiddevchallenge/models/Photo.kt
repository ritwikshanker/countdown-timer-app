package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Photo(
    @SerializedName("full")
    var full: String?, // https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081
    @SerializedName("large")
    var large: String?, // https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=600
    @SerializedName("medium")
    var medium: String?, // https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=300
    @SerializedName("small")
    var small: String? // https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=100
)