package com.example.myapplication.ui.detalle

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.myapplication.databinding.ActivityHoroscopoDetalleBinding
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
    }

    private fun initUI() {
        iniUIState()
    }

    private fun iniUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoDetalleViewModel.state.collect{
                    when(it){
                        HoroscopoDetalleState.Loading -> loaodingState()
                        is HoroscopoDetalleState.Error -> errorState()
                        is HoroscopoDetalleState.Success -> successState()
                    }
                }
            }
        }
    }

    private fun successState() {
        TODO("Not yet implemented")
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }

    private fun loaodingState() {
        TODO("Not yet implemented")
    }
}