package com.mghafori.comics.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailToolBar(
    onShareClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    isFavorite: Boolean
) {
    val favoriteIcon = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder;
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 8.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Share Icon",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onShareClick() })
            Icon(
                imageVector = favoriteIcon,
                contentDescription = "Favorite Icon",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onFavoriteClick() })
        }
    }
}