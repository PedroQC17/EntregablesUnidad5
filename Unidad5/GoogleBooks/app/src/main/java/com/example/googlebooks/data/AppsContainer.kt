package com.example.googlebooks.data

import com.example.googlebooks.network.BooksApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface  AppsContainer{

    //URL base correcta de Google books api
    val booksPhotosRepository : BooksPhotosRepository
}

class DefaultAppContainer : AppsContainer{
    private val baseUrl = "https://www.googleapis.com/books/v1/"
    
    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit : Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()


    private val retrofitService: BooksApiService by lazy{
        retrofit.create(BooksApiService:: class.java)
    }

    override val booksPhotosRepository: BooksPhotosRepository by lazy {
        NetworkBooksPhotosRepository(retrofitService)
    }
}