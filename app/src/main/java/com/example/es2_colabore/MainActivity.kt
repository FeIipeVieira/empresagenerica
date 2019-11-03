package com.example.es2_colabore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // btnAjuda.stateListAnimator = null

        //Login
        btnFazer_login.setOnClickListener {
            fazerLogin()
        }
        //Ajuda
        btnAjuda_login.setOnClickListener{
            Toast.makeText(this,"O importante são os amigos feitos no percorrer do percurso!", Toast.LENGTH_SHORT).show()
        }
        //Fazer cadastro
        acessarCadastro.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    // Tenta fazer login ao Firebase
    private fun fazerLogin(){
        val email = etE_mail_login.text.toString()
        val senha = etSenha_login.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha)
            .addOnCompleteListener {
                //Se funcionar
                if(it.isSuccessful){
                    Toast.makeText(this,"Login feito com sucesso!",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainMenu::class.java)
                    startActivity(intent)
                }else{
                    return@addOnCompleteListener
                }
            }
            //Se não funcionar
            .addOnFailureListener{
                Toast.makeText(this,"Falha ao fazer login: ${it.message}",Toast.LENGTH_SHORT).show()
            }
    }




}
