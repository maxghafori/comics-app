package com.mghafori.comics.presentation.ui.comic

sealed class ComicDetailEvent {
    data class GetComicDetailEvent(
        val id: Int
    ) : ComicDetailEvent()
}