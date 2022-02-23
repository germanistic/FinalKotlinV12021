package com.example.finalkotlinv12021

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


lateinit var service :ApiService

class Detalles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)


        //Boton salir
        val btnSalirDetalles = findViewById<Button>(R.id.btnSalirDetalles)

        btnSalirDetalles.setOnClickListener{

            Toast.makeText(this, "Saliendo de la aplicación", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Salir:: class.java)
            startActivity(intent)
        }

        //Boton Volver a cargar otro Producto
        val btnVolverDetalles = findViewById<Button>(R.id.btnVolverDetalles)

        btnVolverDetalles.setOnClickListener{
            Toast.makeText(this, "Cargando Otro Equipo", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Productos:: class.java)
            startActivity(intent)
        }
        //Boton imagenes
        val btnImg = findViewById<Button>(R.id.btnImg)

        btnImg.setOnClickListener{
            Toast.makeText(this, "Imagenes", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Imagenes:: class.java)
            startActivity(intent)
        }

        //Variable Retrofit que trae el Json
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ApiService::class.java)
        getAllPosts()
    }

    private fun getAllPosts(){
        val tvDatosApi = findViewById<TextView>(R.id.tvDatosApi)
        tvDatosApi.movementMethod = ScrollingMovementMethod()

        //Recibimos todos los posts

        service.getAllPosts().enqueue(object: Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val postList:List<Post>? = response.body()
                if(postList !=null){
                    for (listapost in postList.indices){
                        tvDatosApi.append("UserID ${postList[listapost].userId}\n"+
                                "ID ${postList[listapost].id}\n"+
                                "TITLE ${postList[listapost].title}\n"+
                                "BODY ${postList[listapost].body}\n\n"
                        )
                    }
                }
            }
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }
}
