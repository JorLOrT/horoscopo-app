package com.example.myapplication.ui.detalle

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoDetalleViewModel @Inject constructor(): ViewModel() {
    private var _state = MutableStateFlow<HoroscopoDetalleState>(HoroscopoDetalleState.Loading)
    val state: StateFlow<HoroscopoDetalleState> = _state
}