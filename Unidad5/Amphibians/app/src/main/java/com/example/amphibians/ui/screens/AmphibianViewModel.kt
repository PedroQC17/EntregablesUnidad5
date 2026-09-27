package com.example.amphibians.ui.screens

import retrofit2.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibiansApplication
import com.example.amphibians.data.AmphibianPhotosRepository
import com.example.amphibians.model.AmphibiansPhoto
import kotlinx.coroutines.launch
import okio.IOException

sealed interface AmphibianUiState{
    data class Success( val photos: List<AmphibiansPhoto>) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}

class AmphibianViewModel(
    private val amphibianPhotosRepository: AmphibianPhotosRepository
) : ViewModel(){
    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibianPhotos()
    }

    fun getAmphibianPhotos(){
        viewModelScope.launch {
            amphibianUiState = AmphibianUiState.Loading
            amphibianUiState = try {
                AmphibianUiState.Success(amphibianPhotosRepository.getAmphibianPhotos())
            } catch (e: IOException){
                AmphibianUiState.Error
            } catch (e: HttpException){
                AmphibianUiState.Error
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibianPhotosRepository = application.container.amphibianPhotosRepository
                AmphibianViewModel(amphibianPhotosRepository = amphibianPhotosRepository)
            }
        }
    }

}
