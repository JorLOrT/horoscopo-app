package com.example.myapplication.ui.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.HoroscopoModel
import com.example.myapplication.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopoDetalleViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase): ViewModel() {
    private var _state = MutableStateFlow<HoroscopoDetalleState>(HoroscopoDetalleState.Loading)
    val state: StateFlow<HoroscopoDetalleState> = _state

    lateinit var horoscope: HoroscopoModel

    fun getHoroscope(sign: HoroscopoModel){
        horoscope = sign
        viewModelScope.launch {
            _state.value = HoroscopoDetalleState.Loading
            val result = withContext(Dispatchers.IO){
                getPredictionUseCase(sign.name)
            }
            if(result != null){
                _state.value = HoroscopoDetalleState.Success(result.horoscope, result.sign, horoscope)
            }else{
                _state.value = HoroscopoDetalleState.Error("Error al obtener la predicción")
            }
        }

    }

}