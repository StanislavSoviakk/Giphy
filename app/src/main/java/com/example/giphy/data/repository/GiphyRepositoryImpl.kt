package com.example.giphy.data.repository

import com.example.giphy.data.remote.GiphyApi
import com.example.giphy.data.remote.dto.GiphyDTO
import com.example.giphy.domain.repository.GiphyRepository
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(
    private val api: GiphyApi
): GiphyRepository {
    override suspend fun getTrendingGifs(): GiphyDTO {
        return api.getGifs()
    }
}