package com.mghafori.comics.presentation.ui.comic

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mghafori.comics.cache.ComicDao
import com.mghafori.comics.cache.model.ComicEntityMapper
import com.mghafori.comics.model.Comic
import com.mghafori.comics.network.interactor.GetComic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicDetailViewModel
@Inject
constructor(
    private val getComic: GetComic,
    private val comicDao: ComicDao,
    private val entityMapper: ComicEntityMapper,
) : ViewModel() {
    val comic: MutableState<Comic?> = mutableStateOf(null)
    val loading = mutableStateOf(true)
    val hasError = mutableStateOf(false)
    val isFavorite = mutableStateOf(false)

    fun onTriggerEvent(event: ComicDetailEvent) {
        viewModelScope.launch {
            when (event) {
                is ComicDetailEvent.GetComicDetailEvent -> {
                    if (comic.value == null) {
                        getComicDetail(event.id)
                    }
                    checkIsFavorit(event.id)
                }
                is ComicDetailEvent.FavoriteComicEvent -> {
                    if (isFavorite.value) {
                        removeComicFromCache(event.comic.num)
                    } else {
                        saveComicToCache(event.comic)
                    }
                }
            }
        }
    }

    private fun getComicDetail(comicId: Int) {
        getComic.execute(comicId).onEach { dataState ->
            hasError.value = false
            loading.value = dataState.loading
            dataState.data?.let { data ->
                comic.value = data
            }
            dataState.error?.let { error ->
                hasError.value = true
            }
        }.launchIn(viewModelScope)
    }

    private suspend fun getComicFromCache(comicNum: Int): Comic? {
        return comicDao.getComicById(comicNum.toString())?.let { comicEntity ->
            entityMapper.mapToDomainModel(comicEntity)
        }
    }

    private suspend fun saveComicToCache(comic: Comic) {
        comicDao.insertComic(entityMapper.mapFromDomainModel(comic))
        isFavorite.value = true
    }

    private suspend fun checkIsFavorit(num: Int) {
        isFavorite.value = getComicFromCache(num) != null
    }

    private suspend fun removeComicFromCache(comicNum: String) {
        comicDao.deleteComic(comicNum)
        isFavorite.value = false
    }

}