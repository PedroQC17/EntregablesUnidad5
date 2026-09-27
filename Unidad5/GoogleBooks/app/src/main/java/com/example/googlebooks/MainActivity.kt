package com.example.googlebooks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.googlebooks.ui.screens.BookViewModel
import com.example.googlebooks.ui.screens.HomeScreen
import com.example.googlebooks.ui.theme.GoogleBooksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleBooksTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val bookViewModel: BookViewModel = viewModel(factory = BookViewModel.Factory)
                    HomeScreen(
                        bookUiState = bookViewModel.bookUiState,
                        retryAction = { bookViewModel.getBooks() }
                    )
                }
            }
        }
    }
}
