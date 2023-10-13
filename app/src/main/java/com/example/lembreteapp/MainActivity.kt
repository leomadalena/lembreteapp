package com.example.lembreteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cadastroUsuario(view: View){
        val txtEmail = findViewById<TextInputEditText>(R.id.txt_email)
        val txtSenha = findViewById<TextInputEditText>(R.id.txt_senha)
        val email = txtEmail.text.toString()
        val senha = txtSenha.text.toString()

        val autenticacao = FirebaseAuth.getInstance()
        autenticacao.createUserWithEmailAndPassword(
            email,senha
        ).addOnSuccessListener { authResult ->
            authResult.user?.sendEmailVerification()
            println("Sucesso ao cadastrar")
        }
    }
}