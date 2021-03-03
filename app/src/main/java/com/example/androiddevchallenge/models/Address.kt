package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Address(
    @SerializedName("address1")
    var address1: Any?, // null
    @SerializedName("address2")
    var address2: Any?, // null
    @SerializedName("city")
    var city: String?, // Jersey City
    @SerializedName("country")
    var country: String?, // US
    @SerializedName("postcode")
    var postcode: String?, // 07097
    @SerializedName("state")
    var state: String? // NJ
)