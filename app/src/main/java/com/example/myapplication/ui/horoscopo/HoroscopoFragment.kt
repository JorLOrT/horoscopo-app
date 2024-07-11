package com.example.myapplication.ui.horoscopo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHoroscopoBinding
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
        horoscopoAdapter = HoroscopoAdapter()
        binding.rvHoroscopo.apply {
            layoutManager = LinearLayoutManager(context)
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