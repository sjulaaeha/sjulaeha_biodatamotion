package com.example.biodatamotion.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.biodatamotion.R

class RiwayatPendidikanAdapter(private val items: List<RiwayatPendidikan>) : RecyclerView.Adapter<RiwayatPendidikanAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_riwayat_pendidikan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Tidak ada binding data karena layout kosong
    }

    override fun getItemCount(): Int = items.size
} 