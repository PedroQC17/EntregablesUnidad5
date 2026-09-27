package com.example.amphibians.data

import com.example.amphibians.network.AmphibianApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import retrofit2.Retrofit

interface AppsContainer{
    val amphibianPhotosRepository : AmphibianPhotosRepository
}

class DefaultAppContainer : AppsContainer{
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/amphibians"

    private val retrofit : Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService:: class.java)
    }

    override val amphibianPhotosRepository : AmphibianPhotosRepository by lazy {
        NetworkAmphibianPhotosRepository(retrofitService)
    }
}