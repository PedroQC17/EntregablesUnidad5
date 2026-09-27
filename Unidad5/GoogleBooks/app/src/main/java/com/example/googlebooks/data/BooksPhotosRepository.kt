package com.example.googlebooks.data

import com.example.googlebooks.network.BooksApiService

data class BookInfo(
    val title: String,
    val thumbnailUrl: String
)

interface BooksPhotosRepository {
    suspend fun getBooks(query: String): List<BookInfo>
}

class NetworkBooksPhotosRepository(
    private val booksApiService: BooksApiService
) : BooksPhotosRepository {

    override suspend fun getBooks(query: String): List<BookInfo> {
        val response = booksApiService.searchBooks(query)
        val items = response.items ?: emptyList()

        val books = mutableListOf<BookInfo>()

        for (book in items) {
            val title = book.volumeInfo?.title ?: "Sin título"
            book.volumeInfo?.imageLinks?.thumbnail?.let { url ->
                val secureUrl = url.replace("http://", "https://")
                books.add(BookInfo(title = title, thumbnailUrl = secureUrl))
            }
        }

        return books
    }
}
