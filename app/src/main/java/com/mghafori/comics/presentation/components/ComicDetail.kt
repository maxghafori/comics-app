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
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ComicDetail(
    comicId: Int?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Comic $comicId")
        CoilImage(
            imageRequest = ImageRequest.Builder(LocalContext.current)
                .data("https://imgs.xkcd.com/comics/comet_visitor.png")
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