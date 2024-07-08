package com.example.myapplication.ui.horoscopo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHoroscopoBinding


class HoroscopoFragment : Fragment() {

    private var _binding : FragmentHoroscopoBinding? = null
    // Se asegura que no sea nulo
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}