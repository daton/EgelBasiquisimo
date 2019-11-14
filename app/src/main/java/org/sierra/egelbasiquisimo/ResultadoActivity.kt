package org.sierra.egelbasiquisimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        var calificacion=(Globales.aciertos)!!.div(1.0f*Globales.cuestionario!!.size)*10.0f
  textoResultado.setText("Aciertos: ${Globales.aciertos} \n\n Calificación: $calificacion")

        regresar.setOnClickListener {
            var i= Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
