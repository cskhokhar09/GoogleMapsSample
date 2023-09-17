package com.csk.mymapssample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csk.mymapssample.domain.GetAddressUseCase
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val getAddressUseCase: GetAddressUseCase
): ViewModel() {

    private val _formattedAddress = MutableStateFlow("Formatted Address")
    val formattedAddress : StateFlow<String> = _formattedAddress

    fun getFormattedAddressByLatLng(latLng: String){
        viewModelScope.launch {
            _formattedAddress.value = getAddressUseCase(latLng, "AIzaSyCkDFcEOVDQctO5C6DmTKL5E5_Y3ZVDn_k")
        }
    }
}