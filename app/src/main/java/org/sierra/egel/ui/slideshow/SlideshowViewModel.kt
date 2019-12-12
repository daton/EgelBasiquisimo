package org.sierra.egel.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "B.- Desarrollo e implementación de aplicaciones computacionales"
    }
    val text: LiveData<String> = _text
}