package com.csk.mymapssample.domain

import com.csk.mymapssample.data.model.GoogleMapApiResponse
import com.google.android.gms.maps.model.LatLng

interface MapsRepository {
    suspend fun getFormattedAddress(latLng: String, key: String): GoogleMapApiResponse
}