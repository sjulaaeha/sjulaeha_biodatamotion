package com.example.biodatamotion.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.biodatamotion.databinding.FragmentDashboardBinding
import com.example.biodatamotion.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.biodatamotion.ui.dashboard.RiwayatPendidikan
import com.example.biodatamotion.ui.dashboard.RiwayatPendidikanAdapter
import com.bumptech.glide.Glide

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        // Tambahkan kode Glide untuk memuat foto profil dari URL
        Glide.with(this)
            .load("https://i.pinimg.com/736x/7e/a0/ab/7ea0abc784479204db3118a172c31a19.jpg")
            .placeholder(R.drawable.ic_biodata_black_24dp)
            .error(R.drawable.ic_biodata_black_24dp)
            .centerCrop()
            .into(binding.imageFotoProfil)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}