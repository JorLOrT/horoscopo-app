package com.example.myapplication.data

import android.util.Log
import com.example.myapplication.data.network.HoroscopoApiService
import com.example.myapplication.data.network.response.PredictionResponse
import com.example.myapplication.domain.Repository
import com.example.myapplication.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiService: HoroscopoApiService) : Repository {
    override suspend fun getPrediction(sign: String) : PredictionModel? {
        runCatching {
            apiService.getHoroscopo(sign)
        }.onSuccess {
            // Manejar la respuesta exitosa
            return it.toDomain()
        }.onFailure {
            // Manejar la excepción
            Log.i("Error", "Error: ${it.message}")
        }
        return null
    }
}