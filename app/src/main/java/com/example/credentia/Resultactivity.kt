package com.example.credentia

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Resultactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultactivity)
        val hide =supportActionBar?.hide()


        val name = findViewById<TextView>(R.id.name1)
        val email = findViewById<TextView>(R.id.email)
        val about = findViewById<TextView>(R.id.about)
        val namedet= intent.getStringExtra(MainActivity.KEY)
        val emaildet =intent.getStringExtra(MainActivity.EM)
        val aboutdet = intent.getStringExtra(MainActivity.AB)
        name.text = namedet.toString()
        email.text = emaildet.toString()
        about.text = aboutdet.toString()




    }
}