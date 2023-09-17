package com.csk.mymapssample.ui.screen

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.csk.mymapssample.ui.viewmodel.LocationViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng

const val TAG = "HOME_SCREEN"

@SuppressLint("MissingPermission")
@Composable
fun HomeScreen() {
    val viewModel: LocationViewModel = hiltViewModel()
    var formattedAddress = viewModel.formattedAddress.collectAsStateWithLifecycle().value
    val onLocationNotFound = remember{mutableStateOf("Location Not Found")}
    var userLocation by remember{ mutableStateOf(LatLng(0.0,0.0)) }
    val context = LocalContext.current

    var isLocationGranted by remember{ mutableStateOf(
        ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED
    ) }

    //viewModel.getFormattedAddressByLatLng("37.278060,-121.838030")
    Log.i(TAG,"formatted address = $formattedAddress")
    LocationText(text = formattedAddress)

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            isLocationGranted = true
            getLocation(context) { location ->
                viewModel.getFormattedAddressByLatLng(location)
            }
        } else {
            isLocationGranted = false
            Toast.makeText(context,"Please allow location permission", Toast.LENGTH_SHORT).show()
        }
    }

    val scope = rememberCoroutineScope()

    if(isLocationGranted){
        getLocation(context) { location ->
            viewModel.getFormattedAddressByLatLng(location)
        }
    }else{
        LaunchedEffect(key1 = Unit) {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
}

@Composable
fun LocationText(text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.fillMaxSize()) {
        Text(
            text = text,
            modifier = Modifier.padding(16.dp))
    }
}

@SuppressLint("MissingPermission")
private fun getLocation(context: Context, onResult: (String) -> Unit){
    val fusedLocationProviderClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    fusedLocationProviderClient.lastLocation.addOnCompleteListener {
        val location: Location? = it.result
        if (location != null) {
            onResult("${location.latitude},${location.longitude}")
            Log.i(TAG,"${location.latitude},${location.longitude}")
        } else {
            onResult("0.0,0.0")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    MyMapsSampleTheme {
//        HomeScreenPreview()
//    }
//}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Formatted Address",
            modifier = Modifier.padding(16.dp))
    }
}