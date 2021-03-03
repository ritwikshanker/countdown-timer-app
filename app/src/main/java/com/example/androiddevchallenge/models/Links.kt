package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Links(
    @SerializedName("organization")
    var organization: Organization?,
    @SerializedName("self")
    var self: Self?,
    @SerializedName("type")
    var type: Type?
)