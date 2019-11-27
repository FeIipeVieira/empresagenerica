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
            val email = etE_mail_login.text.toString()
            val senha = etSenha_login.text.toString()
            if (checa_email(email) and (checa_senha(senha))){
                fazerLogin(email,senha)
                //Essa parte comentada se refere as tentativas de testar o acesso ao banco de dados como função
                /*val resp = fazerLogin2(email,senha)
                if (resp ){
                    Toast.makeText(this,"Login feito com sucesso!",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainMenu::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Falha ao fazer login: $resp",Toast.LENGTH_SHORT).show()
                }*/
            }else {
                Toast.makeText(this, "Por favor digite email e/ou senha corretamente.", Toast.LENGTH_SHORT).show()
            }

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
    fun fazerLogin(email:String, senha:String ){
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
