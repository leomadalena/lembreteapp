package com.example.lembreteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class CadastroUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_paciente)
    }

    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }
    private val bd by lazy {
        FirebaseFirestore.getInstance()
    }
    fun cadastro(view: View)
    {
        val txtEmail = findViewById<TextInputEditText>(R.id.txt_email)
        val txtSenha = findViewById<TextInputEditText>(R.id.txt_senha)
        val txtCpf = findViewById<TextInputEditText>(R.id.txt_cpf)
        val txtDataNascimento = findViewById<TextInputEditText>(R.id.txt_data)
        val nome = findViewById<TextInputEditText>(R.id.txt_nome)
        val email = txtEmail.text.toString()
        val senha = txtSenha.text.toString()

        val dados = mapOf(
            "nome" to nome.text.toString(),
            "cpf" to txtCpf.text.toString(),
            "idade" to txtDataNascimento.text.toString()
        )

        bd
            .collection("usuarios")
            .document(txtCpf.text.toString())
            .set(dados)
            .addOnSuccessListener {
                exibirMsg("Bd atualizado!")
            }
        autenticacao.createUserWithEmailAndPassword(
            email,senha
        ).addOnSuccessListener { authResult ->
            authResult.user?.sendEmailVerification()
            println("Sucesso ao cadastrar")
            exibirMsg("Sucesso ao cadastrar!")
        }
    }

    fun exibirMsg(texto: String){
        Toast.makeText(this, texto,Toast.LENGTH_LONG).show()
    }
}