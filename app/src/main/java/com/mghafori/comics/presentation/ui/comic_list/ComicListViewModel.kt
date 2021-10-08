package com.mghafori.comics.presentation.ui.comic_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mghafori.comics.model.Comic
import com.mghafori.comics.network.interactor.GetComic
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ComicListViewModel : ViewModel() {
    val comic: MutableState<Comic?> = mutableStateOf(null)
    private val comicId: MutableState<Int> = mutableStateOf(0)

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

    private fun getCurrentComic() {
        val getComic = GetComic()
        getComic.execute(null).onEach {
            comic.value = it
        }.launchIn(viewModelScope)
    }

    private fun getNextComic() {
        val getComic = GetComic()
        getComic.execute(comicId = comicId.value + 1).onEach {
            comic.value = it
            comicId.value = comicId.value + 1
        }.launchIn(viewModelScope)
    }

    private fun getPreviousComic() {
        if (comicId.value > 1) {
            val getComic = GetComic()
            getComic.execute(comicId = comicId.value - 1).onEach {
                comic.value = it
                comicId.value = comicId.value - 1
            }.launchIn(viewModelScope)
        }

    }
}