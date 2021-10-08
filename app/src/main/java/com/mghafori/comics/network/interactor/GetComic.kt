package com.mghafori.comics.network.interactor

import com.google.gson.GsonBuilder
import com.mghafori.comics.model.Comic
import com.mghafori.comics.network.ComicService
import com.mghafori.comics.network.model.ComicDtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetComic {
    var comicDtoMapper: ComicDtoMapper = ComicDtoMapper();
    var comicService: ComicService = Retrofit.Builder()
        .baseUrl("https://xkcd.com")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(ComicService::class.java)

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