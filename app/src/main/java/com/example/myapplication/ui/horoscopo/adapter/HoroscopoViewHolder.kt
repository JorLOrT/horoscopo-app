package com.example.myapplication.ui.horoscopo.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemHoroscopoBinding
import com.example.myapplication.domain.HoroscopoInfo

class HoroscopoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopo: HoroscopoInfo, onItemSelected: (HoroscopoInfo) -> Unit){
        val context = binding.tvTitle.context
        binding.ivHoroscopo.setImageResource(horoscopo.img)
        binding.tvTitle.text = context.getString(horoscopo.name)

        binding.rvHoroscopo.setOnClickListener {
            startRotationAnimation(binding.ivHoroscopo, newLambda = { onItemSelected(horoscopo)})
        }
    }

    private fun startRotationAnimation(view: View, newLambda: ()-> Unit){
        view.animate().apply {
            duration = 500
            // Flujo de la animación ... velocidad constante
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction {
                newLambda()
            }
            start()
        }
    }

}