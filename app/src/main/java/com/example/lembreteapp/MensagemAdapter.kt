package com.example.lembreteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter


class MensagemAdapter(
    private val lista: List<String>
): Adapter<MensagemAdapter.MensagemViewHolder>() {
    inner class MensagemViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtNome: TextView = itemView.findViewById(R.id.txtNome)
        val txtTexto: TextView = itemView.findViewById(R.id.txtTexto)
        val txtHora: TextView = itemView.findViewById(R.id.txtHora)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViewHolder {
        return MensagemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_view_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MensagemViewHolder, position: Int) {
        val nome = lista[position]
        holder.txtNome.text = nome
        //holder.txtTexto.text = "Texto"
        //holder.txtHora.text = "Hora"
    }
}