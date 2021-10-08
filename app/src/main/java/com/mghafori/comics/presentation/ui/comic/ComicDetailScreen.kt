package com.mghafori.comics.presentation.ui.comic

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.mghafori.comics.presentation.components.ComicDetail
import com.mghafori.comics.presentation.components.DetailToolBar
import com.mghafori.comics.presentation.theme.ComicsTheme

@Composable
fun ComicDetailScreen(
    comicId: Int?,
    viewModel: ComicDetailViewModel
) {
    val comic = viewModel.comic.value
    val loading = viewModel.loading.value
    val hasError = viewModel.hasError.value
    val isFavorite = viewModel.isFavorite.value
    val context = LocalContext.current

    if (comic == null && comicId != null && !hasError) {
        viewModel.onTriggerEvent(ComicDetailEvent.GetComicDetailEvent(comicId))
    }
    ComicsTheme {
        Scaffold(
            topBar = {
                DetailToolBar(
                    onShareClick = {
                        if (comic != null) {
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, comic.title + "\n" + comic.img)
                                type = "text/plain"
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            context.startActivity(shareIntent)
                        }
                    },
                    isFavorite = isFavorite,
                    onFavoriteClick = {
                        if (comic != null) {
                            viewModel.onTriggerEvent(
                                ComicDetailEvent.FavoriteComicEvent(comic)
                            )
                        }
                    }
                )
            }
        ) {
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