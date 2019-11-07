package org.sierra.egelbasiquisimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


class MainActivity : AppCompatActivity() {

    //Aqui capturaremos las variables obtenidas del spinner temas y spinner nnumero
    //estas las pasaremos al json
    var miTema=String()
    var miNumero:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_inicio)
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

        temas.add("A1. Diagnóstico del problema")
        temas.add("A2. Modelado de los requerimientos")

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
                miNumero=item.toString().toInt()
                //Toast.makeText(applicationContext,"Seleccionaste este elemento "+item,Toast.LENGTH_SHORT).show()
                // if(item=="Otros") textoOtos.visibility=View.VISIBLE


            }

        }
        //termina spinner2

        //Ahora al oprimir el boton obtenemos el tema y las preguntas
        empezar.setOnClickListener {
            Toast.makeText(applicationContext, "Tema es $miTema y el numero de preg es $miNumero", Toast.LENGTH_LONG).show()
        }


        //Aqui nos dirijiremos al que ya teniamos


    }


    fun chingaTuPutaCogidaMadreElQueLoLea(tema:String, numero:Int):List<Temas>{

        var valorJson=  application.assets.open("temas.json").bufferedReader().use {
            it.readLine()
        }
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<Array<Temas>> = moshi.adapter(Array<Temas>::class.java)
        val preguntas = adapter.fromJson(valorJson)
        val pregunta=preguntas?.get(0)
        val preguntasListas=preguntas?.toList()




        return preguntasListas!!
    }
}
