package com.mghafori.comics.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mghafori.comics.cache.model.ComicEntity

@Dao
interface ComicDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertComic(comic: ComicEntity): Long

    @Query("DELETE FROM comics WHERE num = :primaryKey")
    suspend fun deleteComic(primaryKey: String): Int

    @Query("SELECT * FROM comics WHERE num = :num")
    suspend fun getComicById(num: String): ComicEntity?

    @Query("SELECT * FROM comics")
    suspend fun getAllFavoriteComics(): List<ComicEntity>
}