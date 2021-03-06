package com.mghafori.comics.presentation.ui.comic_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mghafori.comics.model.Comic
import com.mghafori.comics.network.interactor.GetComic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicListViewModel
@Inject
constructor(
    private val getComic: GetComic
) : ViewModel() {
    val comic: MutableState<Comic?> = mutableStateOf(null)
    private val comicId: MutableState<Int> = mutableStateOf(0)
    val loading = mutableStateOf(false)
    val query = mutableStateOf("")
    val hasError = mutableStateOf(false)

    init {
        if (comic.value == null) {
            onTriggerEvent(ComicListEvent.CurrentComicEvent)
        }
    }

    fun onTriggerEvent(event: ComicListEvent) {
        viewModelScope.launch {
            when (event) {
                is ComicListEvent.CurrentComicEvent -> {
                    getCurrentComic()
                }
                is ComicListEvent.NextComicEvent -> {
                    getNextComic()
                }
                is ComicListEvent.PreviousComicEvent -> {
                    getPreviousComic()
                }
            }
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }

    private fun getCurrentComic() {
        getComic.execute(null).onEach { dataState ->
            loading.value = dataState.loading
            dataState.data?.let { data ->
                comic.value = data
            }
            dataState.error?.let { error ->
                hasError.value = true
            }
        }.launchIn(viewModelScope)
    }

    private fun getNextComic() {
        getComic.execute(comicId = comicId.value + 1).onEach { dataState ->
            loading.value = dataState.loading
            dataState.data?.let { data ->
                comic.value = data
                comicId.value = comicId.value + 1
            }
            dataState.error?.let { error ->
                hasError.value = true
            }
        }.launchIn(viewModelScope)
    }

    private fun getPreviousComic() {
        if (comicId.value > 1) {
            getComic.execute(comicId = comicId.value - 1).onEach { dataState ->
                loading.value = dataState.loading
                dataState.data?.let { data ->
                    comic.value = data
                    comicId.value = comicId.value - 1
                }
                dataState.error?.let { error ->
                    hasError.value = true
                }
            }.launchIn(viewModelScope)
        }

    }
}