package org.sierra.egelbasiquisimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class ExamenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recucleView=  recyclerview as RecyclerView
        val adaptador=TemasListAdapter(this)
        recucleView.adapter=adaptador
        adaptador.setTemas(Globales.cuestionario!!)

        recucleView.layoutManager= LinearLayoutManager(this)


        Toast.makeText(applicationContext,"Valor:"+Globales.cuestionario!!.size, Toast.LENGTH_LONG).show()



    }
}
