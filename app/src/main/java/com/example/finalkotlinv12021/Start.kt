package com.example.finalkotlinv12021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.milliseconds


class Start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        var progressBar1 = findViewById<ProgressBar>(R.id.progressBar1)
        progressBar1.visibility =  View.INVISIBLE

        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener{
            progressBar1.visibility = View.VISIBLE
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }
    }
}