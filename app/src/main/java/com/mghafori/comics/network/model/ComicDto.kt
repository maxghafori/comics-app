package com.mghafori.comics.network.model

import com.google.gson.annotations.SerializedName

data class ComicDto(
    @SerializedName("num")
    var num: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("news")
    var news: String,

    @SerializedName("img")
    var img: String,

    @SerializedName("transcript")
    var transcript: String,

    @SerializedName("day")
    var day: String,

    @SerializedName("month")
    var month: String,

    @SerializedName("year")
    var year: String,

    @SerializedName("link")
    var link: String,

    @SerializedName("alt")
    var alt: String,

    @SerializedName("safeTitle")
    var safeTitle: String,
)