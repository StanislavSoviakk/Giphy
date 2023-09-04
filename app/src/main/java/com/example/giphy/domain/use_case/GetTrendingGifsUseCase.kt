package com.example.giphy.domain.use_case

import com.example.giphy.common.Resource
import com.example.giphy.data.remote.dto.toGiphy
import com.example.giphy.domain.model.Giphy
import com.example.giphy.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTrendingGifsUseCase @Inject constructor(
    private val repository: GiphyRepository
) {
    operator fun invoke(): Flow<Resource<List<Giphy>>> = flow {
        try {
            emit(Resource.Loading<List<Giphy>>())
            val gifs = repository.getTrendingGifs().data.map { it.toGiphy() }
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