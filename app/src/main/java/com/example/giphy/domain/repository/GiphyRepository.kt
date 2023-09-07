package com.example.giphy.domain.repository

import com.example.giphy.common.Resource
import com.example.giphy.domain.model.Giphy
import kotlinx.coroutines.flow.Flow

interface GiphyRepository {

    fun getTrendingGifs(): Flow<Resource<List<Giphy>>>

    fun getGifs(query: String): Flow<Resource<List<Giphy>>>
}