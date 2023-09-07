package com.example.giphy.domain.use_case

import com.example.giphy.common.Resource
import com.example.giphy.domain.model.Giphy
import com.example.giphy.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGifUseCase @Inject constructor(
    private val repository: GiphyRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<Giphy>>> =
        repository.getGifs(query = query)
}