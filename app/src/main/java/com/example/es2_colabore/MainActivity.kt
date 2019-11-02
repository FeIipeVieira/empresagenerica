package com.example.es2_colabore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // btnAjuda.stateListAnimator = null
        btnAcessar.setOnClickListener {

        }

        btnAcessar.setOnClickListener {

            val intent = Intent(this, MainMenu::class.java)

            Toast.makeText(this,"Login com sucesso!", Toast.LENGTH_SHORT).show()

            startActivity(intent)

        }
        btnAjuda.setOnClickListener{



            Toast.makeText(this,"Rosas são vermelhas violetas são azuis, ainda não funciona!", Toast.LENGTH_SHORT).show()



        }
        acessarCadastro.setOnClickListener{



            Toast.makeText(this,"O importante é os amigos feitos no percorrer do percurso!", Toast.LENGTH_SHORT).show()



        }

    }
}
