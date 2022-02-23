package com.example.finalkotlinv12021

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Salir : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salir)

        val finishTime = 5 //5secs

        val handler = Handler()
        handler.postDelayed({ this@Salir.finishAffinity() }, (finishTime * 500).toLong())

    }
}