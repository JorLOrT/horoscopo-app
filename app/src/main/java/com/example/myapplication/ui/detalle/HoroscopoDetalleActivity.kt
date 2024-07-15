package com.example.myapplication.ui.detalle

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHoroscopoDetalleBinding
import com.example.myapplication.domain.model.HoroscopoModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoDetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopoDetalleBinding
    private val horoscopoDetalleViewModel: HoroscopoDetalleViewModel by viewModels<HoroscopoDetalleViewModel>()

    private val args: HoroscopoDetalleActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopoDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopoDetalleViewModel.getHoroscope(args.tipo)
    }

    private fun initUI() {
        initiListener()
        iniUIState()
    }

    private fun initiListener() {
        binding.ivBack.setOnClickListener{
            finish()
        }
    }

    private fun iniUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoDetalleViewModel.state.collect{
                    when(it){
                        HoroscopoDetalleState.Loading -> loaodingState()
                        is HoroscopoDetalleState.Error -> errorState()
                        is HoroscopoDetalleState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(state: HoroscopoDetalleState.Success) {
        binding.progressBar.isVisible = false
        binding.tvTitulo.text = state.sign
        binding.tvBody.text = state.prediction

        val img = when(state.horoscopoModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(img)
    }

    private fun errorState() {
        binding.progressBar.isVisible = false
    }

    private fun loaodingState() {
        binding.progressBar.isVisible = true
    }
}