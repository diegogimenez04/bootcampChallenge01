package com.example.desafiobootcampsemana10enero

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _savedText: MutableLiveData<String> = MutableLiveData()

    val savedTextLiveData: LiveData<String>
        get() = _savedText

    fun saveText(text: String){
        _savedText.value = text
    }
}