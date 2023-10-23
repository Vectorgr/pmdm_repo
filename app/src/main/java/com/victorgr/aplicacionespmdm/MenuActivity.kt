package com.victorgr.aplicacionespmdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.victorgr.aplicacionespmdm.BoardgamesApp.BoardgamesActivity
import com.victorgr.aplicacionespmdm.HelloApp.HelloApp
import com.victorgr.aplicacionespmdm.IMCApp.IMCCalculator
import com.victorgr.aplicacionespmdm.MessageApp.Mensajeria

class MenuActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp =  findViewById<Button>(R.id.btnHelloApp);
        var btnMensajeApp =  findViewById<Button>(R.id.btnMensajeApp);
        var btnIMCApp =  findViewById<Button>(R.id.btnIMCApp);
        var btnBoardgameApp =  findViewById<Button>(R.id.btnBoardgameApp);

        btnHelloApp.setOnClickListener{
            navigateHelloApp();
        }
        btnMensajeApp.setOnClickListener{
            navigateMensajeApp();
        }
        btnIMCApp.setOnClickListener{
            navigateIMCApp();
        }
        btnBoardgameApp.setOnClickListener{
            navigateBoardgamesApp();
        }

    }
    fun navigateHelloApp(){
        var intent = Intent(this, HelloApp::class.java);
        startActivity(intent);
    }
    fun navigateMensajeApp(){
        var intent = Intent(this, Mensajeria::class.java);
        startActivity(intent);
    }
    fun navigateIMCApp(){
        var intent = Intent(this, IMCCalculator::class.java);
        startActivity(intent);
    }
    fun navigateBoardgamesApp(){
        var intent = Intent(this, BoardgamesActivity::class.java);
        startActivity(intent);
    }
}