package org.sierra.egelbasiquisimo.ui.tools

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToolsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "C.Gestión de proyectos de tecnologías de información"
    }
    val text: LiveData<String> = _text
}