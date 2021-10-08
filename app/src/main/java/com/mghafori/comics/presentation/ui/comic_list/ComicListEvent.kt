package com.mghafori.comics.presentation.ui.comic_list

sealed class ComicListEvent {
    object CurrentComicEvent : ComicListEvent()
    object NextComicEvent : ComicListEvent()
    object PreviousComicEvent : ComicListEvent()
}