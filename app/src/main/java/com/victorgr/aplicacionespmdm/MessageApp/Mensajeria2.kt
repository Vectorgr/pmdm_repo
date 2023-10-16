package com.victorgr.aplicacionespmdm.MessageApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.victorgr.aplicacionespmdm.R

class Mensajeria2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensajeria2)
        var btnSend = findViewById<Button>(R.id.btnSend);

        var etMens = findViewById<EditText>(R.id.etMens);
        var cajaMens = findViewById<TextView>(R.id.cajaMensaje);

        var msg: String = intent.extras?.getString("mensaje").orEmpty()
        cajaMens.text= msg;
        btnSend.setOnClickListener{
            var resp:String = etMens.text.toString();
            if(resp.isNotEmpty()){
                var textIntent = Intent(this, Mensajeria::class.java);
                textIntent.putExtra("respuesta",resp)
                startActivity(textIntent);
            }



        }
    }
}