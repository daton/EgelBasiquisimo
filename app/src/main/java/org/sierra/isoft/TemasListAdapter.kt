package org.sierra.isoft

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TemasListAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<TemasListAdapter.TemasViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var temas = emptyList<Temas>() // Cached copy of words

    inner class TemasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreItemView: TextView = itemView.findViewById(R.id.textoPregunta)
        //Aqui irian otras vistas invocadas con el view  elemal y el id
        val radio1View: RadioButton=itemView.findViewById(R.id.radioButton1)
        val radio2View: RadioButton=itemView.findViewById(R.id.radioButton2)
        val radio3View: RadioButton=itemView.findViewById(R.id.radioButton3)
        val radio4View: RadioButton=itemView.findViewById(R.id.radioButton4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemasViewHolder {
        val itemView = inflater.inflate(R.layout.recycler_view, parent, false)
        return TemasViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TemasViewHolder, position: Int) {
        val current = temas[position]
        holder.nombreItemView.text = current.pregunta
        holder.radio1View.text=current.opciones[0].titulo
        holder.radio2View.text=current.opciones[1].titulo
        holder.radio3View.text=current.opciones[2].titulo
        holder.radio4View.text=current.opciones[3].titulo
    }

    internal fun setTemas(temas: List<Temas>) {
        this.temas = temas
        notifyDataSetChanged()
    }

    override fun getItemCount() = temas.size
}

