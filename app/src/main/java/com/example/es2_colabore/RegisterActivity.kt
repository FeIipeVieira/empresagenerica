package com.example.es2_colabore

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*

class RegisterActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btn_register_register.setOnClickListener {
            fazerCadastro()
        }

        tv_already_register.setOnClickListener {
            finish()
        }
    }

    private fun fazerCadastro(){
        val email = et_email_register.text.toString()
        val senha = et_password_register.text.toString()

        if (email.isEmpty() || senha.isEmpty()){
            Toast.makeText(this,"Por favor digite email e/ou senha corretamente.", Toast.LENGTH_LONG).show()
            return
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,"Usuário criado com sucesso!",Toast.LENGTH_SHORT).show()
                    Log.d("Main","Criou usuário com uid: ${it.result?.user?.uid}")
                    finish()
                }else{
                    return@addOnCompleteListener
                }
            }
            .addOnFailureListener{
                Toast.makeText(this,"Falha ao criar usuário; ${it.message}",Toast.LENGTH_SHORT).show()
                Log.d("Registro","Falha ao criar usuário: ${it.message}")
            }
    }

}