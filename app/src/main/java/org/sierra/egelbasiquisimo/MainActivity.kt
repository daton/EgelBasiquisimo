package org.sierra.egelbasiquisimo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_inicio.*
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


class MainActivity : AppCompatActivity() {

    //Aqui capturaremos las variables obtenidas del spinner temas y spinner nnumero
    //estas las pasaremos al json
    var miTema=String()
    var miNumero:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_inicio)
        //Ocultar la barra de arriba
        supportActionBar?.hide()



/**
        val recucleView=  recyclerview as RecyclerView
        val adaptador=TemasListAdapter(this)
        recucleView.adapter=adaptador
        adaptador.setTemas(chingaTuPutaCogidaMadreElQueLoLea())

        recucleView.layoutManager= LinearLayoutManager(this)


        Toast.makeText(applicationContext,"Valor:"+chingaTuPutaCogidaMadreElQueLoLea().size, Toast.LENGTH_LONG).show()
        **/


val temas=ArrayList<String>()
        val numero=ArrayList<Int>()

        temas.add("A1")
        temas.add("A2")
        temas.add("B1");
        temas.add("B2");
        temas.add("B3");
        temas.add("C1");
        temas.add("C2");

        numero.add(2);
        numero.add(4);
        numero.add(8);


        //Obtenemos del sprinner
        var spinner=   spinner
        var spinner2=spinner2


        var adapter= ArrayAdapter<String>(applicationContext, android.R.layout.simple_spinner_item, temas)
        var adapter2= ArrayAdapter<Int>(applicationContext, android.R.layout.simple_spinner_item, numero)


        adapter.setDropDownViewResource(R.layout.simple_spinner)
        adapter2.setDropDownViewResource(R.layout.simple_spinner2)
// Apply the adapter to the spinner
        spinner.adapter = adapter
        spinner2.adapter=adapter2


        //Ïnicia spinner 1
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var item=        parent?.getItemAtPosition(position)
                //El siguiente funciona bien

                (parent?.getChildAt(0) as TextView).setTextColor(Color.WHITE)
               // (parent?.getChildAt(0) as TextView).textSize = 5f


                miTema=item.toString()
                //  Toast.makeText(applicationContext,"Seleccionaste este elemento "+item,Toast.LENGTH_SHORT).show()
                // if(item=="Otros") textoOtos.visibility=View.VISIBLE


            }

        }
        //termina spinner 1
        //inicia sprinner 2
        spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var item=        parent?.getItemAtPosition(position)
                //El siguiente funciona bien
                //Capturamos el valor seleccioando y lo pasamos al variable miTema
                (parent?.getChildAt(0) as TextView).setTextColor(Color.WHITE)
                miNumero=item.toString().toInt()
                //Toast.makeText(applicationContext,"Seleccionaste este elemento "+item,Toast.LENGTH_SHORT).show()
                // if(item=="Otros") textoOtos.visibility=View.VISIBLE


            }

        }
        //termina spinner2

        //Ahora al oprimir el boton obtenemos el tema y las preguntas
        empezar.setOnClickListener {

            //Invocamos el metodo pasandole como argumentos los valores del tema y el numero de rpeguntas seleccioando
          var miCuestioanrio=  buscarPorTemayNumeroDePreguntas(miTema, miNumero)

           //Nos manda un mensaje en pantalla que nos indica el tema que escogimos y el número de preguntas que seleccionamos
          //  Toast.makeText(applicationContext, "Tema es $miTema y el numero de preg es $miNumero Las preguntas halladas son ${miCuestioanrio.size}", Toast.LENGTH_LONG).show()

            //Nos vamos al otro layout
            var i= Intent(this, ExamenUnaPreguntaActivity::class.java)
            startActivity(i)
            finish()

        }


        //Aqui nos dirijiremos al que ya teniamos


    }

    //Algoritmo de ordenamiento para opciones
    fun ordenarOpciones(){
       // var arreglo:List<Int>
       // arreglo= ArrayList<Int>()
        //Genermos un set
        Log.i("JA","que paso")

        var numeros:Set<Int>
        numeros=LinkedHashSet<Int>()


        while(numeros.size<4){


            val numerito = (0..3).random()

            numeros.add(numerito)
        }
        numeros.forEach {
            Log.i("JA", "VALOR:${it}")
        }
    }


    fun buscarPorTemayNumeroDePreguntas(area:String, numero:Int):List<Temas>{

        var valorJson=  application.assets.open("temas.json").bufferedReader().use {
            it.readLine()
        }
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<Array<Temas>> = moshi.adapter(Array<Temas>::class.java)
        val preguntas = adapter.fromJson(valorJson)
        val pregunta=preguntas?.get(0)
        //La siguiente variable contiene el arreglo de rpegunats en su totalidad con todos sus temas
        //debemos de buscar el tema y el numero de rpeguntas de dicho teme
        //tal como se muestra en los argumentos del del metodo
        val preguntasListas=preguntas?.toList()
 var indice=0
        var  cuestionario:List<Temas>
        cuestionario=ArrayList<Temas>()

        //Algoritomo para buscar:
        preguntasListas?.forEach{
            //depuramos
         //   Log.i("NOO","pREGUNTA ENCONTRADA ${it.pregunta}vuelta numero $indice para el tema $area" )
            if(it.area==area){
                if(indice<numero){
                    Log.i("NOO", "Titulo de la pregunta ${it.pregunta}")
                    cuestionario.add(it)
                    indice++;
                }
            }
        }

        //Otro algoritmo para cambiar el orden de las opciones
        Globales.cuestionario=cuestionario

        return cuestionario!!
    } //Aqui termina la funcion buscarPorTemayNumeroDePreguntas
}
