package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Video(
    @SerializedName("embed")
    var embed: String? // <iframe src="https://www.youtube.com/embed/xaXbs1fRFRM" frameborder="0" allowfullscreen></iframe>
)