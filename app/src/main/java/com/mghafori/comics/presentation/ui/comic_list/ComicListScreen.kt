package com.mghafori.comics.presentation.ui.comic_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mghafori.comics.presentation.components.ComicList
import com.mghafori.comics.presentation.theme.ComicsTheme

@Composable
fun ComicListScreen(
    onNavigateToDetail: (String) -> Unit,
    viewModel: ComicListViewModel
) {
    val comic = viewModel.comic.value
    val loading = viewModel.loading.value
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
                ComicList(
                    comic = comic,
                    onNavigateToDetail = onNavigateToDetail,
                    onNextComic = { viewModel.onTriggerEvent(ComicListEvent.NextComicEvent) },
                    onPreviousComic = { viewModel.onTriggerEvent(ComicListEvent.PreviousComicEvent) }
                )
            }
        }
    }
}