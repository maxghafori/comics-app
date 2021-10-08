package com.mghafori.comics.di


import com.google.gson.GsonBuilder
import com.mghafori.comics.network.ComicService
import com.mghafori.comics.network.model.ComicDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideComicMapper(): ComicDtoMapper {
        return ComicDtoMapper()
    }

    @Singleton
    @Provides
    fun provideComicService(): ComicService {
        return Retrofit.Builder()
            .baseUrl("https://xkcd.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ComicService::class.java)
    }
}