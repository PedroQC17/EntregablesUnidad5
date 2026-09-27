package com.example.amphibians.data

import com.example.amphibians.model.AmphibiansPhoto
import com.example.amphibians.network.AmphibianApiService

interface  AmphibianPhotosRepository{
    suspend fun getAmphibianPhotos(): List <AmphibiansPhoto>
}

class NetworkAmphibianPhotosRepository(
    private val amphibianApiService : AmphibianApiService
) : AmphibianPhotosRepository {
    override suspend fun getAmphibianPhotos(): List<AmphibiansPhoto> = amphibianApiService.getPhotos()

}