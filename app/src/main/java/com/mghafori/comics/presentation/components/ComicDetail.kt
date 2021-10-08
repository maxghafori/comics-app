package com.mghafori.comics.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mghafori.comics.model.Comic

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
            Text(
                text = comic.title,
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth(),
            )
            ComicImage(
                imageUrl = comic.img, modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

        }
    }
}