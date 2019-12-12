package org.sierra.egel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


/*
Este actiovity esta ligado al activity main, el cual tiene un recyclerview, que contiene el listado
de todas las pregunats que desees, desplegadas al mismo tiempo, que en el caso de mensajeria si
funcionaria bien, en el caso de ´reguntas  para cuestionarios interactivos, se recomienda mostrar de una en una

 */
class ExamenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recucleView=  recyclerview as RecyclerView
        val adaptador= TemasListAdapter(this)
        recucleView.adapter=adaptador
        adaptador.setTemas(Globales.cuestionarioMalas!!)

        recucleView.layoutManager= LinearLayoutManager(this)


        Toast.makeText(applicationContext,"Valor:"+ Globales.cuestionarioMalas!!.size, Toast.LENGTH_LONG).show()

regresar.setOnClickListener {
    var i= Intent(applicationContext, MainActivity::class.java)
    startActivity(i)
}

    }
}
