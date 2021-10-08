package com.mghafori.comics.presentation.ui.comic

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
class ComicDetailViewModel
@Inject
constructor(
    private val getComic: GetComic
) : ViewModel() {
    val comic: MutableState<Comic?> = mutableStateOf(null)

    fun onTriggerEvent(event: ComicDetailEvent) {
        viewModelScope.launch {
            when (event) {
                is ComicDetailEvent.GetComicDetailEvent -> {
                    if (comic.value == null) {
                        getComicDetail(event.id)
                    }
                }
            }
        }
    }

    private fun getComicDetail(comicId: Int) {
        getComic.execute(comicId).onEach {
            comic.value = it
        }.launchIn(viewModelScope)
    }

}