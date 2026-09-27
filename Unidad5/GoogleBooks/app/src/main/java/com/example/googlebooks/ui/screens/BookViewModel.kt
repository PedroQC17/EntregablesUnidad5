package com.example.googlebooks.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.googlebooks.GoogleBooksApplication
import com.example.googlebooks.data.BookInfo
import com.example.googlebooks.data.BooksPhotosRepository
import kotlinx.coroutines.launch

sealed interface BookUiState {
    data class Success(val books: List<BookInfo>) : BookUiState
    object Error : BookUiState
    object Loading : BookUiState
}

class BookViewModel(private val booksPhotosRepository: BooksPhotosRepository) : ViewModel() {
    var bookUiState: BookUiState by mutableStateOf(BookUiState.Loading)
        private set

    init {
        getBooks("jazz history")
    }

    fun getBooks(query: String = "jazz history") {
        viewModelScope.launch {
            bookUiState = BookUiState.Loading
            bookUiState = try {
                BookUiState.Success(booksPhotosRepository.getBooks(query))
            } catch (e: Exception) {
                e.printStackTrace()
                BookUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as GoogleBooksApplication)
                val repository = application.container.booksPhotosRepository
                BookViewModel(booksPhotosRepository = repository)
            }
        }
    }
}
