package com.example.googlebooks.network

import com.example.googlebooks.model.BookItem
import com.example.googlebooks.model.BookResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {

    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("key") apiKey: String = "AIzaSyBU7MmpxOC0HIqyQQz0DunVp1AKoXfd9mU"
    ): BookResponse

    @GET("volumes/{id}")
    suspend fun getBookDetails(@Path("id") id: String): BookItem
}