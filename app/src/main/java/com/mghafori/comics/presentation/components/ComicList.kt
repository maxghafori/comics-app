package com.mghafori.comics.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.request.ImageRequest
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ComicList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
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
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {}) {
                Text("Previous")
            }
            Button(onClick = {}) {
                Text("Next")
            }
        }

    }
}