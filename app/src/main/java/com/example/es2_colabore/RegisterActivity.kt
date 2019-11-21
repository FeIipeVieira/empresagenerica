package com.example.es2_colabore

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import android.text.Editable
import android.text.TextWatcher

class RegisterActivity : AppCompatActivity(){

    //carrega o layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        //Guardar registro no Firebase
        btn_register_register.setOnClickListener {
            fazerCadastro()
        }

        //Checa se usuário está dentro dos parâmetros
        checar_usuário()
        //Checa se e-mail está dentro dos parâmetros
        checa_email()
        //Checa se a senha (digita sua senha) está dentro dos parâmetros
        checa_senha1()
        //Checa se senha (confirme a senha) está dentro dos parâmetros
        checa_senha2()
    }


    //-------------------------- FUNÇÕES ------------------------------------------

    private fun fazerCadastro(){
        val email = et_email_register.text.toString()
        val senha = et_password_register.text.toString()

        /*
        Variáveis adicionais pra guardar
         */
        var username = et_username_register.text.toString()

        if((textView.text.equals("OK")) and (textView2.text.equals("OK")) and (textView3.text.equals("OK"))){
            Toast.makeText(this,"Por favor conserte os campos com erro", Toast.LENGTH_LONG).show()
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
    //Checa se usuário está dentro dos parâmetros
    private fun checar_usuário(){
        et_username_register.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(et_username_register.text.toString().length<5){
                    textView.text = "Nome de usuário muito curto"
                }else{
                    textView.text = "Ok"
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }
    //Checa se e-mail está dentro dos parâmetros
    private fun checa_email(){
        et_email_register.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(et_email_register.text.contains("@") and (et_email_register.text.length>6)){
                    val para = et_email_register.text.split("@")

                    if(para.size>1){
                        textView2.text = "Ok"
                    }else{
                        textView2.text = "Formato de Email incorreto"
                    }
                }else{
                    textView2.text = "Formato de Email incorreto"
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }
    //Checa se senha ( no 1° campo) está dentro dos parâmetros
    private fun checa_senha1(){
        et_password_register.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if((et_password_register.text.length>6) and (et_password_register.text.length == etvaldo.text.length) and (et_password_register.text.contains(etvaldo.text))){
                    textView3.text = "Ok"


                }else{
                    textView3.text = "Erro nas senhas"
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }
    //Checa se a senha (no 2º campo) está dentro dos prâmetros
    private fun checa_senha2(){
        etvaldo.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if((et_password_register.text.length>6) and (et_password_register.text.length == etvaldo.text.length) and (et_password_register.text.contains(etvaldo.text))){
                    textView3.text = "Ok"

                }else{
                    textView3.text = "Erro nas senhas"
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }



    //---------------------------------------ÁREA DE TESTES------------------------------------------------

    /*

    private fun authLinkdin(){
        LISessionManager.getInstance(applicationContext)
            .init(this, buildScope()//pass the build scope here
                , object : AuthListener() {
                    fun onAuthSuccess() {
                        // Authentication was successful. You can now do
                        // other calls with the SDK.
                        Toast.makeText(
                            this@RegisterActivity,
                            "Successfully authenticated with LinkedIn.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    fun onAuthError(error: LIAuthError) {
                        // Handle authentication errors
                        Log.e(RegisterActivity.TAG, "Auth Error :" + error.toString())
                        Toast.makeText(
                            this@MainActivity,
                            "Failed to authenticate with LinkedIn. Please try again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }, true
            )//if TRUE then it will show dialog if
        // any device has no LinkedIn app installed to download app else won't show anything
    }*/

}