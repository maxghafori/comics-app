package com.mghafori.comics.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.request.ImageRequest
import com.mghafori.comics.model.Comic
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ComicDetail(
    comic: Comic?
) {
    if (comic == null) {
        Text(text = "Invalid Comic")
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = comic.title)
            CoilImage(
                imageRequest = ImageRequest.Builder(LocalContext.current)
                    .data(comic.img)
                    .crossfade(true)
                    .build(),
                imageLoader = ImageLoader.Builder(LocalContext.current)
                    .availableMemoryPercentage(0.25)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}