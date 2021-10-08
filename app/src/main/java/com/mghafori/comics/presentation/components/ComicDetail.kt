package com.mghafori.comics.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mghafori.comics.model.Comic

@Composable
fun ComicDetail(
    comic: Comic?
) {
    if (comic == null) {
        Text(
            text = "Comic Not Available!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            textAlign = TextAlign.Center
        )
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
            comic.transcript?.let { Text(text = it, modifier = Modifier.padding(10.dp)) }

        }
    }
}