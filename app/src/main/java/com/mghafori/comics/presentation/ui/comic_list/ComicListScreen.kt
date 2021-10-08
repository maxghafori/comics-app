package com.mghafori.comics.presentation.ui.comic_list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.mghafori.comics.presentation.components.ComicList
import com.mghafori.comics.presentation.theme.ComicsTheme


@Composable
fun ComicListScreen(
    onNavigateToDetail: (String) -> Unit,
) {
    ComicsTheme {
        Scaffold {
            ComicList(
                onNavigateToDetail = onNavigateToDetail
            )
        }
    }
}