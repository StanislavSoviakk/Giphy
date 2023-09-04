package com.example.giphy.presentation.gifs_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphy.common.Resource
import com.example.giphy.domain.use_case.GetTrendingGifsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GifsListViewModel @Inject constructor(
    private val getTrendingGifsUseCase: GetTrendingGifsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(GifsListState())
    val state: State<GifsListState> = _state

    init {
        getGifs()
    }

    private fun getGifs() {
        getTrendingGifsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = GifsListState(gifs = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        GifsListState(error = result.message ?: "An unexpected error occured")
                }

                is Resource.Loading -> {
                    _state.value = GifsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}