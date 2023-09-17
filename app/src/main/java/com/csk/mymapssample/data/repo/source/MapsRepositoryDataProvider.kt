package com.csk.mymapssample.data.repo.source

import com.csk.mymapssample.data.model.GoogleMapApiResponse
import com.csk.mymapssample.data.repo.source.network.GoogleMapsNetworkApi
import com.csk.mymapssample.domain.MapsRepository
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class MapsRepositoryDataProvider @Inject constructor(private val mapsNetworkApi: GoogleMapsNetworkApi): MapsRepository {
    override suspend fun getFormattedAddress(latLng: String, key: String): GoogleMapApiResponse = mapsNetworkApi.getFormattedAddress(latLng, key)
}