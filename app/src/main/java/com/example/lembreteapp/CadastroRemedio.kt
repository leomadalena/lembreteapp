package com.example.lembreteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore

class CadastroRemedio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_remedio)
    }
    private val bd by lazy {
        FirebaseFirestore.getInstance()
    }

    private fun cadastrar(view: View){

    }
}