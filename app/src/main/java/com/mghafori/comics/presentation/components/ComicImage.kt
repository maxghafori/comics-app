package com.mghafori.comics.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.request.ImageRequest
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ComicImage(
    imageUrl: String,
    modifier: Modifier
) {
    CoilImage(
        imageRequest = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        imageLoader = ImageLoader.Builder(LocalContext.current)
            .availableMemoryPercentage(0.5)
            .crossfade(true)
            .build(),
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = MaterialTheme.colors.primary,
            durationMillis = 500,
            dropOff = 0.65f,
            tilt = 20f
        ),
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}