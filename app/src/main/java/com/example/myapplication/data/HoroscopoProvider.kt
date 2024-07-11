package com.example.myapplication.data

import com.example.myapplication.domain.HoroscopoInfo
import com.example.myapplication.domain.HoroscopoInfo.*
import javax.inject.Inject


class HoroscopoProvider @Inject constructor() {
    fun getHoroscopos(): List<HoroscopoInfo>{
        return listOf(
            Aries, Taurus, Gemini, Cancer, Leo, Virgo, Libra, Scorpio, Sagittarius, Capricorn, Aquarius, Pisces
        )
    }
}