package com.example.giphy.data.repository

import com.example.giphy.common.Resource
import com.example.giphy.data.remote.GiphyApi
import com.example.giphy.data.remote.dto.toGiphy
import com.example.giphy.domain.model.Giphy
import com.example.giphy.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(
    private val api: GiphyApi
) : GiphyRepository {
    override fun getTrendingGifs(): Flow<Resource<List<Giphy>>> = flow {
        try {
            emit(Resource.Loading<List<Giphy>>())
            val gifs = api.getTrendingGifs().data.map { it.toGiphy() }
            emit(Resource.Success<List<Giphy>>(gifs))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Giphy>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }
    }

    override fun getGifs(query: String): Flow<Resource<List<Giphy>>> = flow {
        try {
            emit(Resource.Loading<List<Giphy>>())
            val gifs = api.getGifs(query = query).data.map { it.toGiphy() }
            emit(Resource.Success<List<Giphy>>(gifs))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Giphy>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }
    }
}