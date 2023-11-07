package com.example.lembreteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaReceita : AppCompatActivity() {
    private lateinit var rvlista: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_receita)

        val lista = listOf<String>("aasdf", "badf", "cadf")
        rvlista = findViewById(R.id.rv_lista)
        rvlista.adapter = MensagemAdapter(lista)
        rvlista.layoutManager = LinearLayoutManager(this)
    }


}

