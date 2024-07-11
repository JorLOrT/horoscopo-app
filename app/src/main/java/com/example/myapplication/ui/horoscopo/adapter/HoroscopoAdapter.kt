package com.example.myapplication.ui.horoscopo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.HoroscopoInfo

class HoroscopoAdapter(private var horoscopoList: List<HoroscopoInfo> = emptyList(), private val onItemSelected:(HoroscopoInfo) -> Unit) : RecyclerView.Adapter<HoroscopoViewHolder>() {


    fun updateList(list: List<HoroscopoInfo>){
        horoscopoList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        return HoroscopoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscopo ,parent, false)
        )
    }

    override fun getItemCount(): Int = horoscopoList.size

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.render(horoscopoList[position], onItemSelected)
    }
}