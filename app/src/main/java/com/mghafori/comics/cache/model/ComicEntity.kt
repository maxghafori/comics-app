package com.mghafori.comics.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comics")
data class ComicEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "num")
    var num: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "news")
    var news: String,

    @ColumnInfo(name = "img")
    var img: String,

    @ColumnInfo(name = "transcript")
    var transcript: String,

    @ColumnInfo(name = "day")
    var day: String,

    @ColumnInfo(name = "month")
    var month: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "link")
    var link: String,

    @ColumnInfo(name = "alt")
    var alt: String,

    @ColumnInfo(name = "safeTitle")
    var safeTitle: String,
)