package com.mghafori.comics.presentation.navigation

sealed class Screen(val route: String) {
    object ComicList : Screen("comicList")
    object ComicDetail : Screen("comicDetail")
}