package com.mghafori.comics.model

data class Comic(
    val num: String,
    val title: String,
    val img: String,
    val news: String?,
    val transcript: String?,
    val day: String?,
    val month: String?,
    val year: String?,
    val link: String?,
    val alt: String?,
    val safeTitle: String?,
)