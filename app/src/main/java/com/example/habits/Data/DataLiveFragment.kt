package com.example.habits.Data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataLiveFragment : ViewModel() {
    val msg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}