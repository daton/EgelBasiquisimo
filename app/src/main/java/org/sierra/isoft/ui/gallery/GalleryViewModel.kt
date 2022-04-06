package org.sierra.isoft.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "A.Análisis de sistemas de información"
    }
    val text: LiveData<String> = _text
}