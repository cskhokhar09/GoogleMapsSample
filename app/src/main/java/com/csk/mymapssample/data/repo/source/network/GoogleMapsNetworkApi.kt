package com.csk.mymapssample.data.repo.source.network

import com.csk.mymapssample.data.model.GoogleMapApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleMapsNetworkApi {

    @GET("maps/api/geocode/json")
    suspend fun getFormattedAddress(@Query("latlng") latLng: String, @Query("key") key: String): GoogleMapApiResponse
}