package com.mghafori.comics.di

import com.mghafori.comics.cache.ComicDao
import com.mghafori.comics.cache.model.ComicEntityMapper
import com.mghafori.comics.network.ComicService
import com.mghafori.comics.network.interactor.GetComic
import com.mghafori.comics.network.model.ComicDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorModule {

    @ViewModelScoped
    @Provides
    fun provideGetComic(
        comicService: ComicService,
        comicDtoMapper: ComicDtoMapper,
        comicDao: ComicDao,
        entityMapper: ComicEntityMapper
    ): GetComic {
        return GetComic(
            comicService = comicService,
            comicDtoMapper = comicDtoMapper,
            comicDao = comicDao,
            entityMapper = entityMapper
        )
    }
}