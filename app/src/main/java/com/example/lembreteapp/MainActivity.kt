package com.example.lembreteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loginUsuario(view: View){
        val txtEmail = findViewById<TextInputEditText>(R.id.txt_email)
        val txtSenha = findViewById<TextInputEditText>(R.id.txt_senha)
        val email = txtEmail.text.toString()
        val senha = txtSenha.text.toString()

        val autenticacao = FirebaseAuth.getInstance()
        autenticacao.signInWithEmailAndPassword(
            email,senha
        ).addOnSuccessListener { authResult ->
            println("Sucesso em logar")
        }
    }

    fun cadastroUsuario(view: View){
        val intent = Intent(this, CadastroUsuario::class.java)
        startActivity(intent)
    }
}