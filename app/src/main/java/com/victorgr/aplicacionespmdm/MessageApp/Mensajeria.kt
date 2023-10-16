package com.victorgr.aplicacionespmdm.MessageApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.victorgr.aplicacionespmdm.R

class Mensajeria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensajeria)
        var btnSend = findViewById<Button>(R.id.btnSend);

        var etMens = findViewById<EditText>(R.id.etMens);
        var cajaMens = findViewById<TextView>(R.id.cajaMensaje);

        var msg: String = intent.extras?.getString("respuesta").orEmpty()
        cajaMens.text= msg;
        btnSend.setOnClickListener{
            var resp:String = etMens.text.toString();
            if(resp.isNotEmpty()){
                var textIntent = Intent(this, Mensajeria2::class.java);
                textIntent.putExtra("mensaje",resp)
                startActivity(textIntent);
            }



        }
    }

}