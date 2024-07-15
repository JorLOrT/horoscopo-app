package com.example.myapplication.domain

import com.example.myapplication.data.network.response.PredictionResponse
import com.example.myapplication.domain.model.PredictionModel

// Comunicación entre la capa de data y la capa de dominio

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?

}