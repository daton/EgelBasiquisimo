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

        temas.add("A1. Diagnóstico del problema")
        temas.add("A2. Modelado de los requerimientos")

        //Obtenemos del sprinner
        var spinner=   spinner


        var adapter= ArrayAdapter<String>(applicationContext, android.R.layout.simple_spinner_item, temas)

        adapter.setDropDownViewResource(R.layout.simple_spinner)
// Apply the adapter to the spinner
        spinner.adapter = adapter

        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var item=        parent?.getItemAtPosition(position)
                //El siguiente funciona bien
                  Toast.makeText(applicationContext,"Seleccionaste este elemento "+item,Toast.LENGTH_SHORT).show()
                // if(item=="Otros") textoOtos.visibility=View.VISIBLE


            }

        }


    }


    fun chingaTuPutaCogidaMadreElQueLoLea():List<Temas>{

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
