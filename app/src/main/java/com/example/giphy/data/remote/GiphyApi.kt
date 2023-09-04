package com.example.giphy.data.remote

import com.example.giphy.common.Constants
import com.example.giphy.data.remote.dto.GiphyDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    @GET("trending")
    suspend fun getGifs(
        @Query("api_key") api_key: String = Constants.API_KEY
    ): GiphyDTO
}