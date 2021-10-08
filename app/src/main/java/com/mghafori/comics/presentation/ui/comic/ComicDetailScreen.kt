package com.mghafori.comics.presentation.ui.comic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mghafori.comics.presentation.components.ComicDetail
import com.mghafori.comics.presentation.theme.ComicsTheme

@Composable
fun ComicDetailScreen(
    comicId: Int?,
    viewModel: ComicDetailViewModel
) {
    val comic = viewModel.comic.value
    val loading = viewModel.loading.value
    if (comic == null && comicId != null) {
        viewModel.onTriggerEvent(ComicDetailEvent.GetComicDetailEvent(comicId))
    }
    ComicsTheme {
        Scaffold {
            if (loading) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }
            } else {
                ComicDetail(
                    comic = comic
                )
            }
        }
    }
}