package org.sierra.egelbasiquisimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.examen_una_pregunta.*

class ExamenUnaPreguntaActivity : AppCompatActivity() {

    var indice=0
    var numPregunta=1
    var aciertos=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.examen_una_pregunta)
        //Mostramos la primer pregunta

   siguientePregunta(indice);



        //El boton para siguiente pregunta
        siguiente.setOnClickListener {
            //Limpiamos la que este seleccionada previamente con el siguiente metood

if(radiogrupo.checkedRadioButtonId!=-1) {

    //Primero checamos la respuesta de la pregunta anterior, ya que al oprimir este boton ya se seleciono la primera
    //Capturamos la opcion del usuario
    if (indice < Globales.cuestionario!!.size && findViewById<RadioButton>(radiogrupo.checkedRadioButtonId).text != null && findViewById<RadioButton>(
            radiogrupo.checkedRadioButtonId
        ).text == checarAcierto(Globales.cuestionario!!.get(indice))
    ) {
        aciertos++
    }

    //Limpiamos el radioGroup antes de mostrar la rpegunta siguiente
    if (indice < Globales.cuestionario!!.size) radiogrupo.clearCheck()
  //  Toast.makeText(applicationContext, "Aciertos $aciertos", Toast.LENGTH_LONG).show()


    indice++
    numPregunta++


    if (indice < Globales.cuestionario!!.size) {


        siguientePregunta(indice)
    }else{
        //Pasamos los aciertos a la variable global acierto para que la compratamos en la activity de resultados
        Globales.aciertos=aciertos
        var i=Intent(applicationContext, ResultadoActivity::class.java)
        startActivity(i)
        finish()
    }
}else{
    Toast.makeText(applicationContext, "Debes seleccionar una opcion para continuar", Toast.LENGTH_LONG).show()
}
        }
    }

    fun siguientePregunta( indice:Int){

        var preguntas=Globales.cuestionario;

        var primeraPregunta=preguntas?.get(indice);

        textoNumeroPreg.setText("Pregunta $numPregunta de ${Globales.cuestionario!!.size} ")
        textoPregunta.setText(primeraPregunta?.pregunta)
        //Ajustamos los radiobuttons
        radioButton1.setText(primeraPregunta?.opciones?.get(0)?.titulo)
        radioButton2.setText(primeraPregunta?.opciones?.get(1)?.titulo)
        radioButton3.setText(primeraPregunta?.opciones?.get(2)?.titulo)
        radioButton4.setText(primeraPregunta?.opciones?.get(3)?.titulo)



    }

    fun checarAcierto(pregunta:Temas):String{
        var tituloCorrecta="";
        pregunta.opciones.forEach {
            if(it.acierto){
              tituloCorrecta=  it.titulo
            }
        }
        return tituloCorrecta
    }


}
