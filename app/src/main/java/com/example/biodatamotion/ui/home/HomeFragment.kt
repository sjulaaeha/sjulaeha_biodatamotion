package com.example.biodatamotion.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.biodatamotion.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel
    private val handler = Handler(Looper.getMainLooper())
    private val updateTimeRunnable = object : Runnable {
        override fun run() {
            homeViewModel.updateDateTime()
            handler.postDelayed(this, 1000) // Update setiap 1 detik
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set motivasi
        val motivasiList = listOf(
            "🌟 Motivasi\n“Jangan takut berjalan pelan, yang penting kamu tidak berhenti. Setiap langkah kecil yang kamu ambil hari ini akan membawamu lebih dekat ke impian yang besar.”",
            "🌿 Motivasi\n“Hari ini adalah kesempatan baru untuk belajar, tumbuh, dan menjadi versi terbaik dari dirimu. Tetap semangat, karena proses tidak pernah mengkhianati hasil.”",
            "🔥 Motivasi\n“Meskipun hari ini terasa berat, percayalah bahwa kamu sedang membangun kekuatan yang akan membuatmu luar biasa di masa depan. Teruskan perjuanganmu!”",
            "☀️ Motivasi\n“Setiap pagi membawa harapan baru. Jangan biarkan rasa ragu menghalangi langkahmu. Kamu punya potensi besar, lebih dari yang kamu kira.”"
        )
        val motivasiRandom = motivasiList.random()
        binding.textMotivasi.text = motivasiRandom

        // Set cuaca dummy
        binding.textCuaca.text = "Tangerang — 30°C, Cerah"

        // Observe waktu dan tanggal dari ViewModel
        homeViewModel.currentTime.observe(viewLifecycleOwner) { time ->
            binding.textWaktu.text = time
        }
        
        homeViewModel.currentDate.observe(viewLifecycleOwner) { date ->
            binding.textTanggal.text = date
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        // Mulai update waktu setiap detik
        handler.post(updateTimeRunnable)
    }

    override fun onPause() {
        super.onPause()
        // Hentikan update waktu saat fragment tidak aktif
        handler.removeCallbacks(updateTimeRunnable)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(updateTimeRunnable)
        _binding = null
    }
}