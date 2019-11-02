package com.example.es2_colabore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_busca.*

class Busca : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca)

        ibtnBusca.setOnClickListener {
            val buscado: String = tvBarraBusca.text.toString()

            Toast.makeText(this, "Buscando $buscado...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Perfil_Projeto::class.java )

            startActivity(intent)

        }
    }

}