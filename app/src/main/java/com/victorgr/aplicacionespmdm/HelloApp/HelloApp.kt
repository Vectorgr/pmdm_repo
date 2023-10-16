package com.victorgr.aplicacionespmdm.HelloApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.victorgr.aplicacionespmdm.R

class HelloApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSend = findViewById<Button>(R.id.btnSend);
        var userText = findViewById<EditText>(R.id.etName);
        var textView = findViewById<TextView>(R.id.textName)

        btnSend.setOnClickListener{
            var name:String = userText.text.toString();
            if(name.isNotEmpty()){
                var textIntent = Intent(this, HelloApp2::class.java);
                textIntent.putExtra("extra_name",name)
                startActivity(textIntent);
            }



        }

    }
}