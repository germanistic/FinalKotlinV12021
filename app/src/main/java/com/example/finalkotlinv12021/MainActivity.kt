package com.example.finalkotlinv12021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se utiliza el constructor de la clase User con los siguientes atributos

        val login = User("admin","admin")

        //las variables de los objetos en pantalla ( usuario,password y el boton)

        val userLogin = findViewById<EditText>(R.id.ediUsuario)
        val passLogin = findViewById<EditText>(R.id.ediPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        //Boton de login con las comprobaciones de los campos y envia los datos a la otra activity mediante Bundel e Intent.

        btnLogin.setOnClickListener{
            val user = userLogin.text.toString()
            val pass= passLogin.text.toString()
            val logeo = User(user,pass)

            if(userLogin.text.toString() == login.usuario && passLogin.text.toString() == login.pass)
            {
                Toast.makeText(applicationContext,"Bienvenido al Sistema",Toast.LENGTH_SHORT).show()

                val main = Bundle()
                main.putString("Login", logeo.usuario)

                val intent = Intent(this, Productos:: class.java)
                intent.putExtras(main)
                startActivity(intent)

            }else{
                Toast.makeText(applicationContext, "Error de usuario/contraseña",Toast.LENGTH_SHORT).show()
            }
        }


    }
}