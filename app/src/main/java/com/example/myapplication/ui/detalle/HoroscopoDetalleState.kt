package com.example.myapplication.ui.detalle

sealed class HoroscopoDetalleState {
    data object Loading : HoroscopoDetalleState()
    data class Success(val body: String) : HoroscopoDetalleState()
    data class Error(val message: String) : HoroscopoDetalleState()

}