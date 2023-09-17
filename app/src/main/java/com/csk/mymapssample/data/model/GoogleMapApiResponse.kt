package com.csk.mymapssample.data.model

data class GoogleMapApiResponse(
    val plus_code: PlusCode,
    val results: List<Result>,
    val status: String
)