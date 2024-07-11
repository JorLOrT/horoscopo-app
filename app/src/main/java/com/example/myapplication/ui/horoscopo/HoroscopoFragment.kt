package com.example.myapplication.ui.horoscopo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHoroscopoBinding
import com.example.myapplication.domain.HoroscopoInfo.*
import com.example.myapplication.domain.HoroscopoModel
import com.example.myapplication.ui.horoscopo.adapter.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    // Inyección de dependencias
    private val horoscopoViewModel: HoroscopoViewModel by viewModels<HoroscopoViewModel>()

    private lateinit var horoscopoAdapter: HoroscopoAdapter

    private var _binding : FragmentHoroscopoBinding? = null
    // Se asegura que no sea nulo
    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopoAdapter = HoroscopoAdapter(onItemSelected = {
            val tipo: HoroscopoModel = when(it){
                Aquarius -> HoroscopoModel.Aquarius
                Aries -> HoroscopoModel.Aries
                Cancer -> HoroscopoModel.Cancer
                Capricorn -> HoroscopoModel.Capricorn
                Gemini -> HoroscopoModel.Gemini
                Leo -> HoroscopoModel.Leo
                Libra -> HoroscopoModel.Libra
                Pisces -> HoroscopoModel.Pisces
                Sagittarius -> HoroscopoModel.Sagittarius
                Scorpio -> HoroscopoModel.Scorpio
                Taurus -> HoroscopoModel.Taurus
                Virgo -> HoroscopoModel.Virgo
            }
            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToHoroscopoDetalleActivity(tipo)
            )
        })
        binding.rvHoroscopo.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopoAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoViewModel.horoscopo.collect{
                    horoscopoAdapter.updateList(it)
                }
            }
        }
    }

}