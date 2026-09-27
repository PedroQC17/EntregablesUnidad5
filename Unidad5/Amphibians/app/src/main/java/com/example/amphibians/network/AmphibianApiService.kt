package com.example.amphibians.network

import com.example.amphibians.model.AmphibiansPhoto
import retrofit2.http.GET

interface AmphibianApiService {

    @GET("photos")
    suspend fun getPhotos () : List<AmphibiansPhoto>
}