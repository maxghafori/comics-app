package com.mghafori.comics.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mghafori.comics.model.Comic
import com.mghafori.comics.presentation.navigation.Screen

@Composable
fun ComicList(
    onNavigateToDetail: (String) -> Unit,
    comic: Comic?,
    onNextComic: () -> Unit,
    onPreviousComic: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        if (comic == null) {
            Text(
                text = "Invalid Comic", modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Center
            )
        } else {
            Text(
                text = comic.title,
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth(),
            )
            ComicImage(imageUrl = comic.img, modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clickable {
                    val route = Screen.ComicDetail.route + "/" + comic.num
                    onNavigateToDetail(route)
                })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { onPreviousComic() }) {
                Text("Previous")
            }
            Button(onClick = { onNextComic() }) {
                Text("Next")
            }
        }

    }
}