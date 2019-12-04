package org.sierra.egelbasiquisimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.examen_una_pregunta.*
import java.util.LinkedHashSet

class ExamenUnaPreguntaActivity : AppCompatActivity() {

    var indice=0
    var numPregunta=1
    var aciertos=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.examen_una_pregunta)

        //Ocultar la barra de arriba
        supportActionBar?.hide()
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
    }else{
        Globales.cuestionarioMalas.add(Globales.cuestionario!!.get(indice))
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

        /*
        *ESTA PARTE DEL CODIGOM INVOCA EL METODO ordenarOpciones de la pregunta vigente
         */
        primeraPregunta!!.opciones=ordenarOpciones(primeraPregunta!!.opciones)

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


    fun ordenarOpciones(opciones:List<Opcione>):List<Opcione>{
        // var arreglo:List<Int>
        // arreglo= ArrayList<Int>()
        //Genermos un set
        Log.i("JA","que paso")

        //La siguiente variable es el arreglo de numeros del 1 al 3
        //desordenados
        var numeros:Set<Int>
        numeros= LinkedHashSet<Int>()


        while(numeros.size<4){


            val numerito = (0..3).random()

            numeros.add(numerito)
        }//ya se genero ese arreglo

        //El nuevo orden de opciones

        var opcionesNuevas:List<Opcione>
        opcionesNuevas=ArrayList<Opcione>()

        for( i in 0..3){

            opcionesNuevas.add(opciones.get(numeros.elementAt(i)))
        }
        return  opcionesNuevas
    }

    //El siguiente es para generar el numero de reactivos aleatoriamente



}
