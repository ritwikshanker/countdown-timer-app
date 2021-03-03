package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Contact(
    @SerializedName("address")
    var address: Address?,
    @SerializedName("email")
    var email: String?, // petfindertechsupport@gmail.com
    @SerializedName("phone")
    var phone: String? // 555-555-5555
)