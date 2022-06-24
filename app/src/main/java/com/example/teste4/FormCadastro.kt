package com.example.teste4

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.teste4.databinding.ActivityFormCadastroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef: DatabaseReference = database.getReference("Users")

        myRef.setValue("Users")

        binding.btCadastrar.setOnClickListener {view ->
            
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(view, "Preencha Todos Os Campos!",Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.WHITE)
                snackbar.show()
            }else{
                auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener{ cadastro ->
                    if (cadastro.isSuccessful){
                        val snackbar = Snackbar.make(view, "Sucesso !",Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.WHITE)
                        snackbar.show()
                        binding.editNome.setText("")
                        binding.editEmail.setText("")
                        binding.editSenha.setText("")
                    }

                }.addOnFailureListener{exception ->

                    val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 caracteres!"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um E-mail válido!"
                        is FirebaseAuthUserCollisionException -> "Esta conta já foi Cadastrada!"
                        is FirebaseNetworkException -> "Sem conexão com a Internet!"
                        else -> "Erro ao Cadastrar usuário"
                    }
                    val snackbar = Snackbar.make(view,mensagemErro,Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.WHITE)
                    snackbar.show()
                }

            }
        }

    }
}