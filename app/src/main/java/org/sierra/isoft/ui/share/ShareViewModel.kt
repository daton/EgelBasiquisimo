package org.sierra.isoft.ui.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "D.Implementaciónde redes, bases de datos, sistemas operativosy lenguaje de desarrollo"
    }
    val text: LiveData<String> = _text
}