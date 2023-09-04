package com.example.giphy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.giphy.presentation.gif_details.GifDetailsScreen
import com.example.giphy.presentation.gifs_list.GifsListScreen
import com.example.giphy.ui.theme.GiphyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiphyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.GifsListScreen.route
                    ) {
                        composable(route = Screen.GifsListScreen.route) {
                            GifsListScreen(navController)
                        }
                        composable(
                            route = "${Screen.GifDetailsScreen.route}?gifUrl={gifUrl}",
                            arguments = listOf(navArgument("gifUrl") {
                                type = NavType.StringType
                            })
                        ) {
                            GifDetailsScreen(it.arguments?.getString("gifUrl"))
                        }
                    }
                }
            }
        }
    }
}