package org.sierra.egelbasiquisimo

data class Temas(
    val area: String,
    val claveProfesor: Int,
    val estaBuena: Boolean,
    val id: String,
    val opciones: List<Opcione>,
    val pregunta: String,
    val tema: String,
    val validado: Boolean
)