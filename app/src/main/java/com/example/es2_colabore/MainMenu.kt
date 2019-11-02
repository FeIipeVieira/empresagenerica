package com.example.es2_colabore

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.mainmenu_activity.*

class MainMenu : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainmenu_activity)

        btnBusca.setOnClickListener {
            val intent = Intent(this, Busca::class.java)

            Toast.makeText(this,"Menu de busca.", Toast.LENGTH_SHORT).show()

            startActivity(intent)
        }

        btnPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)

            Toast.makeText(this,"Seu perfil.", Toast.LENGTH_SHORT).show()

            startActivity(intent)
        }


    }



}