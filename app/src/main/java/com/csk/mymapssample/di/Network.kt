package com.csk.mymapssample.di

import com.csk.mymapssample.data.repo.source.MapsRepositoryDataProvider
import com.csk.mymapssample.data.repo.source.network.GoogleMapsNetworkApi
import com.csk.mymapssample.domain.GetAddressUseCase
import com.csk.mymapssample.domain.MapsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {
    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://maps.googleapis.com/")
        .build()

    private val mapsNetworkApi by lazy {
        retrofit.create(GoogleMapsNetworkApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMapsNetworkApi(): GoogleMapsNetworkApi = mapsNetworkApi

    @Singleton
    @Provides
    fun provideMapsRepository(mapsNetworkApi: GoogleMapsNetworkApi): MapsRepository = MapsRepositoryDataProvider(mapsNetworkApi)

    @Singleton
    @Provides
    fun provideAddressUseCase(mapsRepository: MapsRepository): GetAddressUseCase = GetAddressUseCase(mapsRepository)

}