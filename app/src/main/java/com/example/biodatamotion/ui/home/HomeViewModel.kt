package com.example.biodatamotion.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class HomeViewModel : ViewModel() {

    private val _currentTime = MutableLiveData<String>()
    val currentTime: LiveData<String> = _currentTime

    private val _currentDate = MutableLiveData<String>()
    val currentDate: LiveData<String> = _currentDate

    private val _text = MutableLiveData<String>().apply {
        value = "Selamat datang di aplikasi Biodata Motion. Aplikasi ini membantu Anda mengelola biodata dan informasi pendidikan dengan mudah."
    }
    val text: LiveData<String> = _text

    init {
        updateDateTime()
    }

    fun updateDateTime() {
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
        
        val currentTimeString = timeFormat.format(Date())
        val currentDateString = dateFormat.format(Date())
        
        _currentTime.value = currentTimeString
        _currentDate.value = currentDateString
    }
}