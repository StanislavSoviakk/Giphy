package com.example.giphy.di

import com.example.giphy.common.Constants
import com.example.giphy.data.remote.GiphyApi
import com.example.giphy.data.repository.GiphyRepositoryImpl
import com.example.giphy.domain.repository.GiphyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGiphyApi(): GiphyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GiphyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGiphyRepository(api: GiphyApi): GiphyRepository {
        return GiphyRepositoryImpl(api)
    }
}