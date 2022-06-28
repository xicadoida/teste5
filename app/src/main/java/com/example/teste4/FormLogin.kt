package com.example.teste4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        val bt_entrar = findViewById<Button>(R.id.bt_entrar)
        bt_entrar.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        val bt_tela_cadastro = findViewById<Button>(R.id.bt_tela_cadastro)
        bt_tela_cadastro.setOnClickListener {
            val Intent = Intent(this,FormCadastro::class.java)
            startActivity(Intent)
        }
    }
}





