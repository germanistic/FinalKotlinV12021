package com.example.finalkotlinv12021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ListaEquipos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_equipos)


        val btnExit = findViewById<Button>(R.id.btnExit)
        val btnOtro = findViewById<Button>(R.id.btnOtro)
        val btnDetalles = findViewById<Button>(R.id.btnDetalles)

        val tipoVista = findViewById<TextView>(R.id.tvTipoVista)
        val marcaVista = findViewById<TextView>(R.id.tvMarcaVista)
        val modeloVista = findViewById<TextView>(R.id.tvModeloVista)
        val precioVista = findViewById<TextView>(R.id.tvPrecioVista)


        val equipo=intent.getParcelableExtra<Equipo>("Equipo")
        tipoVista.text= equipo?.Tipo.toString()
        marcaVista.text= equipo?.Marca.toString()
        modeloVista.text= equipo?.Modelo.toString()
        precioVista.text= equipo?.Precio.toString()

        btnExit.setOnClickListener{
            //Toast.makeText(this, "Saliendo de la aplicación", Toast.LENGTH_SHORT).show()
            //this.finish()
            Toast.makeText(this, "Saliendo de la aplicación", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Salir:: class.java)
            startActivity(intent)
        }

        btnOtro.setOnClickListener{
            Toast.makeText(this, "Cargando Otro Equipo", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Productos:: class.java)
            startActivity(intent)

        }

        btnDetalles.setOnClickListener{
            Toast.makeText(this, "Detalles", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Detalles:: class.java)
            startActivity(intent)
        }
    }
}
