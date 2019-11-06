package org.sierra.egelbasiquisimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recucleView=  recyclerview as RecyclerView
        val adaptador=TemasListAdapter(this)
        recucleView.adapter=adaptador
        adaptador.setTemas(chingaTuPutaCogidaMadreElQueLoLea())

        recucleView.layoutManager= LinearLayoutManager(this)


        Toast.makeText(applicationContext,"Valor es este:"+chingaTuPutaCogidaMadreElQueLoLea().size, Toast.LENGTH_LONG).show()
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



        //  Toast.makeText(this, "Pero es Pregunta ${pregunta?.area} ", Toast.LENGTH_LONG).show()

        //  var media= MediaPlayer()
        //   var descriptor=application.assets.openFd("sad.mp3")
        //    media.setDataSource(descriptor.fileDescriptor,descriptor.startOffset,descriptor.length)
        //     media.prepare()
        //     media.start()

        return preguntasListas!!
    }
}
