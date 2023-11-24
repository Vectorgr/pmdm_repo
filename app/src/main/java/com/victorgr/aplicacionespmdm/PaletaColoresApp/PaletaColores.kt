package com.victorgr.aplicacionespmdm.PaletaColoresApp

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.victorgr.aplicacionespmdm.BoardgamesApp.Game
import com.victorgr.aplicacionespmdm.BoardgamesApp.GameCategory

import com.victorgr.aplicacionespmdm.R

class PaletaColores : AppCompatActivity() {
    private lateinit var rvColors: RecyclerView
    private lateinit var btnCambiarColores: Button;
    private lateinit var colorAdapter: ColorsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paleta_colores)
        initComponents();
        initUI();

    }
    private val colors = listOf<Colors>(
        Colors("V1 (20%)",50,255,0,0),
        Colors("V2 (35%)",89,255,255,0),
        Colors("V3 (50%)",127,0,0,255),
        Colors("V4 (65%)",165,0,255,0),
        Colors("V5 (80%)",204,0,255,255),
    )

    private fun initComponents() {
        rvColors = findViewById<RecyclerView>(R.id.rvColors)
        btnCambiarColores = findViewById<Button>(R.id.btnCambiarColor);



        btnCambiarColores.setOnClickListener{
            showDialog();
        }

    }
    private fun initUI(){
        colorAdapter = ColorsAdapter(colors)

        rvColors.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvColors.adapter = colorAdapter


    }
    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_colors)

        var indiceSeleccionado : Int = 0;
        var btnChgColor: Button= dialog.findViewById(R.id.btnCambiarColorDialog)

        var rgColors: RadioGroup= dialog.findViewById(R.id.rgColor)
        var rgBarras: RadioGroup= dialog.findViewById(R.id.rgBarras)

        var cardViewH : CardView = findViewById(R.id.h1);


        btnChgColor.setOnClickListener{
            val selectedColorID = rgColors.checkedRadioButtonId
            val selectedRadioButtonColor: RadioButton = rgColors.findViewById(selectedColorID);
            val selectedBarraID = rgBarras.checkedRadioButtonId
            val selectedRadioButtonBarra: RadioButton = rgBarras.findViewById(selectedBarraID);

            when(selectedRadioButtonBarra.text){
                "V1 (20%)" -> indiceSeleccionado = 0
                "V2 (35%)" -> indiceSeleccionado = 1
                "V3 (50%)" -> indiceSeleccionado = 2
                "V4 (65%)" -> indiceSeleccionado = 3
                "V5 (80%)" -> indiceSeleccionado = 4
                "H1 (20%)" -> cardViewH = findViewById<CardView>(R.id.h1);
                "H2 (50%)" -> cardViewH = findViewById<CardView>(R.id.h2);
                "H3 (80%)" -> cardViewH = findViewById<CardView>(R.id.h3);

            }
            if(selectedRadioButtonBarra.text.startsWith('V')) {


                when (selectedRadioButtonColor.text) {
                    "Blanco" -> {
                        colors[indiceSeleccionado].cRed = 255
                        colors[indiceSeleccionado].cGreen = 255
                        colors[indiceSeleccionado].cBlue = 255;
                    }

                    "Rojo" -> {
                        colors[indiceSeleccionado].cRed = 255
                        colors[indiceSeleccionado].cGreen = 0
                        colors[indiceSeleccionado].cBlue = 0;
                    }

                    "Naranja" -> {
                        colors[indiceSeleccionado].cRed = 255
                        colors[indiceSeleccionado].cGreen = 119
                        colors[indiceSeleccionado].cBlue = 0;
                    }

                    "Amarillo" -> {
                        colors[indiceSeleccionado].cRed = 255
                        colors[indiceSeleccionado].cGreen = 255
                        colors[indiceSeleccionado].cBlue = 0;
                    }

                    "Verde" -> {
                        colors[indiceSeleccionado].cRed = 0
                        colors[indiceSeleccionado].cGreen = 255
                        colors[indiceSeleccionado].cBlue = 0;
                    }

                    "Cian" -> {
                        colors[indiceSeleccionado].cRed = 0
                        colors[indiceSeleccionado].cGreen = 255
                        colors[indiceSeleccionado].cBlue = 242;
                    }

                    "Azul" -> {
                        colors[indiceSeleccionado].cRed = 0
                        colors[indiceSeleccionado].cGreen = 0
                        colors[indiceSeleccionado].cBlue = 255;
                    }

                    "Violeta" -> {
                        colors[indiceSeleccionado].cRed = 187
                        colors[indiceSeleccionado].cGreen = 0
                        colors[indiceSeleccionado].cBlue = 255;
                    }

                    "Negro" -> {
                        colors[indiceSeleccionado].cRed = 0
                        colors[indiceSeleccionado].cGreen = 0
                        colors[indiceSeleccionado].cBlue = 0;
                    }

                }
            }else{

                when (selectedRadioButtonColor.text) {
                    "Blanco" -> {
                        cardViewH.setCardBackgroundColor(Color.rgb(255,255,255));

                    }

                    "Rojo" -> {
                        cardViewH.setCardBackgroundColor(Color.rgb(255,0,0));

                    }

                    "Naranja" -> {
                        cardViewH.setCardBackgroundColor(Color.rgb(255,119,255));

                    }

                    "Amarillo" -> {
                        cardViewH.setCardBackgroundColor(Color.rgb(255,255,0));

                    }

                    "Verde" -> {
                        cardViewH.setCardBackgroundColor(Color.rgb(0,255,0));

                    }

                    "Cian" -> {
                        cardViewH.setCardBackgroundColor(Color.rgb(255,255,242));

                    }

                    "Azul" -> {
                        cardViewH.setCardBackgroundColor(Color.rgb(0,0,255));

                    }

                    "Violeta" -> {
                        cardViewH.setCardBackgroundColor(Color.rgb(187,0,255));

                    }

                    "Negro" -> {
                        cardViewH.setCardBackgroundColor(Color.rgb(0,0,0));

                    }

                }

            }
            colorAdapter.notifyDataSetChanged()
            dialog.hide();
            
        }


        dialog.show()


    }


}