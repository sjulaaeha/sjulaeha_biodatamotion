package com.example.biodatamotion.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ini adalah halaman Pendidikan"
    }
    val text: LiveData<String> = _text
}