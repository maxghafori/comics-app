package com.mghafori.comics.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mghafori.comics.cache.model.ComicEntity

@Database(entities = [ComicEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun comicDao(): ComicDao

    companion object {
        val DATABASE_NAME: String = "comic_db"
    }
}