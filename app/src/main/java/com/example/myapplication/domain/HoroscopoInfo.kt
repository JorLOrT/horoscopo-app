package com.example.myapplication.domain

import com.example.myapplication.R

sealed class HoroscopoInfo(val img: Int, val name: Int){
    object Aries: HoroscopoInfo(R.drawable.aries, R.string.aries)
    object Taurus: HoroscopoInfo(R.drawable.tauro, R.string.taurus)
    object Gemini: HoroscopoInfo(R.drawable.geminis, R.string.gemini)
    object Cancer: HoroscopoInfo(R.drawable.cancer, R.string.cancer)
    object Leo: HoroscopoInfo(R.drawable.leo, R.string.leo)
    object Virgo: HoroscopoInfo(R.drawable.virgo, R.string.virgo)
    object Libra: HoroscopoInfo(R.drawable.libra, R.string.libra)
    object Scorpio: HoroscopoInfo(R.drawable.escorpio, R.string.scorpio)
    object Sagittarius: HoroscopoInfo(R.drawable.sagitario, R.string.sagittarius)
    object Capricorn: HoroscopoInfo(R.drawable.capricornio, R.string.capricorn)
    object Aquarius: HoroscopoInfo(R.drawable.aquario, R.string.aquarius)
    object Pisces: HoroscopoInfo(R.drawable.piscis, R.string.pisces)
}
