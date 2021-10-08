package com.mghafori.comics.network.interactor

import com.mghafori.comics.model.Comic
import com.mghafori.comics.network.ComicService
import com.mghafori.comics.network.model.ComicDtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetComic(
    private val comicService: ComicService,
    private val comicDtoMapper: ComicDtoMapper
) {

    fun execute(
        comicId: Int?
    ): Flow<Comic> = flow {
        if (comicId != null) {
            val comic = getComicById(comicId)
            emit(comic)
        } else {
            val comic = getCurrentComic()
            emit(comic)
        }
    }

    private suspend fun getComicById(comicId: Int): Comic {
        return comicDtoMapper.mapToDomainModel(comicService.getById(comic_id = comicId))
    }

    private suspend fun getCurrentComic(): Comic {
        return comicDtoMapper.mapToDomainModel(comicService.getCurrent())
    }
}