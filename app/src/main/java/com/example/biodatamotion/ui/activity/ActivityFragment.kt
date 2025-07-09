package com.example.biodatamotion.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.biodatamotion.databinding.FragmentActivityBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.biodatamotion.ui.dashboard.RiwayatPendidikan
import com.example.biodatamotion.ui.dashboard.RiwayatPendidikanAdapter

class ActivityFragment : Fragment() {

    private var _binding: FragmentActivityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val activityViewModel =
            ViewModelProvider(this).get(ActivityViewModel::class.java)

        _binding = FragmentActivityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Data dummy riwayat pendidikan
        val dataRiwayat = listOf(
            RiwayatPendidikan("Sekolah Dasar", "SDN Munjul 1", "2010 - 2016"),
            RiwayatPendidikan("Sekolah Menengah Pertama", "SMPN 3 Solear", "2016 - 2019"),
            RiwayatPendidikan("Sekolah Menengah Kejuruan", "SMK Karya Bangsa Nusantara", "2019 - 2022"),
            RiwayatPendidikan("Perguruan Tinggi", "Universitas Yatsi Madani", "2023 - Sekarang")
        )
        val adapter = RiwayatPendidikanAdapter(dataRiwayat)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 