package com.example.giphy.presentation

sealed class Screen(val route: String) {
    object GifsListScreen: Screen("gifs_list_screen")
    object GifDetailsScreen: Screen("gif_details_screen")
}