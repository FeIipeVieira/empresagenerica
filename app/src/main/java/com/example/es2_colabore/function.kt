package com.example.es2_colabore

import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

fun helloWorld(name: String = "World"):String{
    return "Hello, ${name}!"
}
fun checa_email(email: String):Boolean{
    if (email.contains("@") and (email.length>6)){
        val para = email.split("@")
        return para.size>1
    }else{
        return false
    }
}
fun checa_senha(senha:String):Boolean{
    return senha.length>=6
}
/* Ainda não consegui fazer essa função funcionar a partir daqui, a versão funcional se encontra em MainActivity
fun fazerLogin2(email:String, senha:String ):Boolean{
    var ok = false
    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha)
        .addOnCompleteListener {
            //Se funcionar
            if(it.isSuccessful){
                //resp = "sucesso"
                ok = true
                //return@addOnCompleteListener
            }else{
                return@addOnCompleteListener
            }
        }
        //Se não funcionar
        .addOnFailureListener{
            //resp = it.message.toString()
        }
    return ok

}*/