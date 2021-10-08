package com.mghafori.comics.presentation.ui.comic

import com.mghafori.comics.model.Comic

sealed class ComicDetailEvent {
    data class GetComicDetailEvent(
        val id: Int
    ) : ComicDetailEvent()

    data class FavoriteComicEvent(
        val comic: Comic
    ) : ComicDetailEvent()
}