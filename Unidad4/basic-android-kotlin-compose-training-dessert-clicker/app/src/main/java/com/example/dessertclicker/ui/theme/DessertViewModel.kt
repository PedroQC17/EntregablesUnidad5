package com.example.dessertclicker.ui.theme

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    private val desserts = Datasource.dessertList

    init {
        _uiState.value = DessertUiState(
            currentDessertImageId = desserts[0].imageId,
            currentDessertPrice = desserts[0].price
        )
    }

    fun onDessertClicked() {
        _uiState.update { currentState ->
            val dessertsSold = currentState.dessertSold + 1
            val nextDessert = determineDessertToShow(dessertsSold)
            currentState.copy(
                revenue = currentState.revenue + currentState.currentDessertPrice,
                dessertSold = dessertsSold,
                currentDessertImageId = nextDessert.imageId,
                currentDessertPrice = nextDessert.price
            )
        }
    }

    private fun determineDessertToShow(dessertsSold: Int): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }
        return dessertToShow
    }
}
