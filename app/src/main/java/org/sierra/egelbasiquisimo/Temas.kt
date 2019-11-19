package org.sierra.egelbasiquisimo

data class Temas(
    val area: String,
    val claveProfesor: Int,
    val estaBuena: Boolean,
    val id: String,
    var opciones: List<Opcione>,
    var pregunta: String,
    val tema: String,
    val validado: Boolean
)