package com.example.giphy.presentation.gifs_list

import com.example.giphy.domain.model.Giphy

data class GifsListState(
    val isLoading: Boolean = false,
    val gifs: List<Giphy> = emptyList(),
    val error: String = "",
)
