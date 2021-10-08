package com.mghafori.comics.presentation.ui.comic

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.mghafori.comics.presentation.components.ComicDetail
import com.mghafori.comics.presentation.theme.ComicsTheme

@Composable
fun ComicDetailScreen(
    comicId: Int?
) {
    ComicsTheme {
        Scaffold {
            ComicDetail(
                comicId = comicId
            )
        }
    }
}