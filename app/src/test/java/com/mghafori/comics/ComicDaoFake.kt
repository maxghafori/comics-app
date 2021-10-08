package com.mghafori.comics

import com.mghafori.comics.cache.ComicDao
import com.mghafori.comics.cache.model.ComicEntity

class ComicDaoFake() : ComicDao {
    override suspend fun insertComic(comic: ComicEntity): Long {
        return 1;
    }

    override suspend fun deleteComic(primaryKey: String): Int {
        return 1;
    }

    override suspend fun getComicById(num: String): ComicEntity? {
        return null;
    }

    override suspend fun getAllFavoriteComics(): List<ComicEntity> {
        return ArrayList<ComicEntity>()
    }

}