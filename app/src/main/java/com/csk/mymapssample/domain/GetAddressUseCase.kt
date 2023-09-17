package com.csk.mymapssample.domain

import android.util.Log
import com.csk.mymapssample.ui.screen.TAG
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class GetAddressUseCase @Inject constructor(
    private val mapsRepository: MapsRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
    ) {
    suspend operator fun invoke(latLng: String, key: String): String {
        var address = ""
        withContext(defaultDispatcher){
            try {
                val response = mapsRepository.getFormattedAddress(latLng, key)
                when(response.status){
                    "OK" -> {
                    Log.i(TAG,"Status = ${response.status}")
                        val result = response.results.filter {
                            it.formatted_address.isNotEmpty()
                        }
                        address = result.first().formatted_address
                    }
                    else -> {
                        Log.i(TAG,"Status = ${response.status}")
                    }
                }

            }catch (ioException: IOException){
                ioException.localizedMessage ?: "error"
            }

        }
        return address.ifEmpty { "Location Not Found" }
    }

}