package com.example.all_neco_lessons.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val messageForA: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageForF1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageForF2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}