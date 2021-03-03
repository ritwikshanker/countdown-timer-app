package com.example.androiddevchallenge.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Animal(
    @SerializedName("age")
    var age: String?, // Young
    @SerializedName("attributes")
    var attributes: Attributes?,
    @SerializedName("breeds")
    var breeds: Breeds?,
    @SerializedName("coat")
    var coat: String?, // Short
    @SerializedName("colors")
    var colors: Colors?,
    @SerializedName("contact")
    var contact: Contact?,
    @SerializedName("description")
    var description: String?, // Nebula is a shorthaired, shy cat. She is very affectionate once she warms up to you.
    @SerializedName("distance")
    var distance: Double?, // 0.4095
    @SerializedName("environment")
    var environment: Environment?,
    @SerializedName("gender")
    var gender: String?, // Female
    @SerializedName("id")
    var id: Int?, // 124
    @SerializedName("_links")
    var links: Links?,
    @SerializedName("name")
    var name: String?, // Nebula
    @SerializedName("organization_id")
    var organizationId: String?, // NJ333
    @SerializedName("photos")
    var photos: List<Photo>?,
    @SerializedName("published_at")
    var publishedAt: String?, // 2018-09-04T14:49:09+0000
    @SerializedName("size")
    var size: String?, // Medium
    @SerializedName("species")
    var species: String?, // Cat
    @SerializedName("status")
    var status: String?, // adoptable
    @SerializedName("tags")
    var tags: List<String>?,
    @SerializedName("type")
    var type: String?, // Cat
    @SerializedName("url")
    var url: String?, // https://www.petfinder.com/cat/nebula-124/nj/jersey-city/nj333-petfinder-test-account/?referrer_id=d7e3700b-2e07-11e9-b3f3-0800275f82b1
    @SerializedName("videos")
    var videos: List<Video>?
)