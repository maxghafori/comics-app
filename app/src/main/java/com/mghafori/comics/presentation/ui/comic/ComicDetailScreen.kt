package com.mghafori.comics.presentation.ui.comic

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.mghafori.comics.presentation.components.ComicDetail
import com.mghafori.comics.presentation.theme.ComicsTheme

@Composable
fun ComicDetailScreen(
    comicId: Int?,
    viewModel: ComicDetailViewModel
) {
    val comic = viewModel.comic.value
    if (comic == null && comicId != null) {
        viewModel.onTriggerEvent(ComicDetailEvent.GetComicDetailEvent(comicId))
    }
    ComicsTheme {
        Scaffold {
            ComicDetail(
                comic = comic
            )
        }
    }
}