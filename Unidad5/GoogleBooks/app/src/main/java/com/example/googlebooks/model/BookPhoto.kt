package com.example.googlebooks.model

import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val items: List<BookItem>? = emptyList()
)

@Serializable
data class BookItem(
    val id: String? = null,
    val volumeInfo: VolumeInfo? = null
)

@Serializable
data class VolumeInfo(
    val title: String? = null,
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String? = null
)
