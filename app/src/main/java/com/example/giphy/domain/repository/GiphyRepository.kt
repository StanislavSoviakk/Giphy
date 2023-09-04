package com.example.giphy.domain.repository

import com.example.giphy.data.remote.dto.GiphyDTO

interface GiphyRepository {

    suspend fun getTrendingGifs(): GiphyDTO
}