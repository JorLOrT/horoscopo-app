package com.example.myapplication.ui.horoscopo.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemHoroscopoBinding
import com.example.myapplication.domain.HoroscopoInfo

class HoroscopoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopo: HoroscopoInfo){
        val context = binding.tvTitle.context
        binding.ivHoroscopo.setImageResource(horoscopo.img)
        binding.tvTitle.text = context.getString(horoscopo.name)
    }

}