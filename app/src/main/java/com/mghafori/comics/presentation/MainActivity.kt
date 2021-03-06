package com.mghafori.comics.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mghafori.comics.presentation.navigation.Screen
import com.mghafori.comics.presentation.ui.comic.ComicDetailScreen
import com.mghafori.comics.presentation.ui.comic.ComicDetailViewModel
import com.mghafori.comics.presentation.ui.comic_list.ComicListScreen
import com.mghafori.comics.presentation.ui.comic_list.ComicListViewModel
import androidx.hilt.navigation.HiltViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.ComicList.route) {
                composable(route = Screen.ComicList.route) {
                    val factory = HiltViewModelFactory(LocalContext.current, it)
                    val viewModel: ComicListViewModel = viewModel(key = "ComicListViewModel",factory = factory)
                    ComicListScreen(
                        onNavigateToDetail = navController::navigate,
                        viewModel = viewModel
                    )
                }
                composable(
                    route = Screen.ComicDetail.route + "/{comicId}",
                    arguments = listOf(navArgument("comicId") {
                        type = NavType.IntType
                    })
                ) {
                    val factory = HiltViewModelFactory(LocalContext.current, it)
                    val viewModel: ComicDetailViewModel = viewModel(key = "ComicDetailViewModel",factory = factory)
                    ComicDetailScreen(
                        comicId = it.arguments?.getInt("comicId"),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}