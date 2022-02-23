package com.example.finalkotlinv12021

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Imagenes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagenes)


        //Boton salir
        val btnSalirApp= findViewById<Button>(R.id.btnSalirApp)

        btnSalirApp.setOnClickListener{
            Toast.makeText(this, "Saliendo de la aplicación", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Salir:: class.java)
            startActivity(intent)
        }
    }
    private fun onBackPressed(function: () -> Unit) {
    }
}