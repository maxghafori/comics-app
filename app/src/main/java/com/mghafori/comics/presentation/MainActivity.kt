package com.mghafori.comics.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mghafori.comics.presentation.navigation.Screen
import com.mghafori.comics.presentation.ui.comic.ComicDetailScreen
import com.mghafori.comics.presentation.ui.comic_list.ComicListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.ComicList.route) {
                composable(route = Screen.ComicList.route) {
                    ComicListScreen(
                        onNavigateToDetail = navController::navigate
                    )
                }
                composable(
                    route = Screen.ComicDetail.route + "/{comicId}",
                    arguments = listOf(navArgument("comicId") {
                        type = NavType.IntType
                    })
                ) {
                    ComicDetailScreen(
                        comicId = it.arguments?.getInt("comicId")
                    )
                }
            }
        }
    }
}