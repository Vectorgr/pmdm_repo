package com.victorgr.aplicacionespmdm.HelloApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.victorgr.aplicacionespmdm.R

class HelloApp2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var txtHola = findViewById<TextView>(R.id.textoHola);
        var nombre: String = intent.extras?.getString("extra_name").orEmpty()
        txtHola.text = "Hola $nombre";
    }
}