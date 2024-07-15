package com.example.myapplication.ui.detalle

import com.example.myapplication.domain.model.HoroscopoModel

sealed class HoroscopoDetalleState {
    data object Loading : HoroscopoDetalleState()
    data class Success(val prediction: String, val sign: String, val horoscopoModel: HoroscopoModel) : HoroscopoDetalleState()
    data class Error(val message: String) : HoroscopoDetalleState()

}