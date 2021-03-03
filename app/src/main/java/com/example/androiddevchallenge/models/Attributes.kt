package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Attributes(
    @SerializedName("declawed")
    var declawed: Boolean?, // false
    @SerializedName("house_trained")
    var houseTrained: Boolean?, // true
    @SerializedName("shots_current")
    var shotsCurrent: Boolean?, // true
    @SerializedName("spayed_neutered")
    var spayedNeutered: Boolean?, // true
    @SerializedName("special_needs")
    var specialNeeds: Boolean? // false
)