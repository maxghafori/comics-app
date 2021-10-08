package com.mghafori.comics.di

import androidx.room.Room
import com.mghafori.comics.cache.AppDatabase
import com.mghafori.comics.cache.ComicDao
import com.mghafori.comics.cache.model.ComicEntityMapper
import com.mghafori.comics.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideDb(app: BaseApplication): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideComicDao(db: AppDatabase): ComicDao {
        return db.comicDao()
    }

    @Singleton
    @Provides
    fun provideCacheComicMapper(): ComicEntityMapper {
        return ComicEntityMapper()
    }

}

