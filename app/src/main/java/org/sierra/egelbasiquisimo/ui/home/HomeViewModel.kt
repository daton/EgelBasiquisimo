package org.sierra.egelbasiquisimo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Estructura general del EGEL-ISOFT por áreas"
    }
    val text: LiveData<String> = _text
}