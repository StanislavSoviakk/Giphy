package com.example.giphy.data.remote

import com.example.giphy.common.Constants
import com.example.giphy.data.remote.dto.GiphyDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    @GET("trending")
    suspend fun getTrendingGifs(
        @Query("api_key") api_key: String = Constants.API_KEY
    ): GiphyDTO

    @GET("search")
    suspend fun getGifs(
        @Query("api_key") api_key: String = Constants.API_KEY,
        @Query("q") query: String
    ): GiphyDTO
}