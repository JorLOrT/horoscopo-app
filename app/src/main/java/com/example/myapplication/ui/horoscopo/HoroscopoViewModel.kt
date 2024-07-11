package com.example.myapplication.ui.horoscopo

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.HoroscopoInfo
import com.example.myapplication.domain.HoroscopoInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HoroscopoViewModel @Inject constructor(): ViewModel() {

    // lista para modificar - mutable
    private var _horoscopo = MutableStateFlow<List<HoroscopoInfo>>(emptyList())
    // para poder leer y no modificar
    val horoscopo: StateFlow<List<HoroscopoInfo>> = _horoscopo

    init{
        _horoscopo.value = listOf(
            Aries, Taurus, Gemini, Cancer, Leo, Virgo, Libra, Scorpio, Sagittarius, Capricorn, Aquarius, Pisces
        )
    }
}