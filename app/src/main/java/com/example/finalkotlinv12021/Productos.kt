package com.example.finalkotlinv12021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Productos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val btnEnviar: Button = findViewById(R.id.btnEnviar)
        val tipo: EditText = findViewById(R.id.tvTipo)
        val marca: EditText = findViewById(R.id.tvMarca)
        val modelo: EditText = findViewById(R.id.tvModelo)
        val precio: EditText = findViewById(R.id.tvPrecio)

        btnEnviar.setOnClickListener {
            equipoTest(tipo, marca, modelo, precio)
        }
    }


    private fun equipoTest(tipo: EditText, marca: EditText, modelo: EditText, precio: EditText) {
        val eqTipo = tipo.text.toString()
        val eqMarca = marca.text.toString()
        val eqModelo = modelo.text.toString()
        val eqPrecio = precio.text.toString()
        val eqDeposito = Equipo(eqTipo, eqMarca, eqModelo, eqPrecio)


        if (eqTipo.isEmpty() || eqMarca.isEmpty() || eqModelo.isEmpty() || eqPrecio.isEmpty()) {
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Equipo cargado con exito", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ListaEquipos::class.java)
            intent.putExtra("Equipo", eqDeposito)
            SystemClock.sleep(1000)
            startActivity(intent)
            finish()
        }

    }



    }
