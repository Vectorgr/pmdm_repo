package com.victorgr.aplicacionespmdm.IMCApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import com.victorgr.aplicacionespmdm.R
import java.text.DecimalFormat

class IMCCalculator : AppCompatActivity() {

    private var isMaleSelected:Boolean = true;
    private var isFemaleSelected:Boolean = false;
    private var currentWeight:Int = 60;
    private var currentAge:Int = 30;
    private var currentHeight:Int = 120;


    private lateinit var viewMale: CardView;
    private lateinit var viewFemale: CardView;
    private lateinit var tvHeight: TextView;
    private lateinit var rsHeight: RangeSlider;
    private lateinit var tvWeight: TextView;
    private lateinit var btnAddWeight: CardView;
    private lateinit var btnSubstractWeight: CardView;

    private lateinit var tvAge: TextView;
    private lateinit var btnAddAge: CardView;
    private lateinit var btnSubstractAge: CardView;

    private lateinit var btnCalcular: CardView;




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculator)

        initComponents();
        initListeners();

    }
    private fun initComponents(){
        viewMale= findViewById<CardView>(R.id.viewMale);
        viewFemale= findViewById<CardView>(R.id.viewFemale);

        tvHeight = findViewById<TextView>(R.id.tvHeight)
        rsHeight = findViewById<RangeSlider>(R.id.rsHeight)

        tvWeight = findViewById(R.id.tvWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)

        tvAge = findViewById(R.id.tvAge)
        btnAddAge = findViewById(R.id.btnAddAge)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)

        btnCalcular = findViewById<CardView>(R.id.btnCalcular)
    }
    private fun initListeners() {
        viewMale.setOnClickListener(){
                setColorComponentMale()}

        viewFemale.setOnClickListener(){
            setColorComponentFemale();
        };
        rsHeight.addOnChangeListener(){ _, value , _ ->

            val df= DecimalFormat("#");
            tvHeight.text = df.format(value) + " cm";
            currentHeight = value.toInt();

        }
        btnAddWeight.setOnClickListener(){
            currentWeight++;
            setWeight()
        }
        btnSubstractWeight.setOnClickListener(){
            if(currentWeight>0){
                currentWeight--;
            }
            setWeight();
        }
        btnAddAge.setOnClickListener(){
            currentAge++;
            setAge()
        }
        btnSubstractAge.setOnClickListener(){
            if(currentAge>0){
                currentAge--;
            }
            setAge();
        }

        btnCalcular.setOnClickListener(){
            val result =calculateIMC();
            var resultIntent = Intent(this, IMCResult::class.java);
            resultIntent.putExtra("result",result)
            startActivity(resultIntent);

            Log.i("IMC", "IMC: $result");
        }

    }

    private fun setColorComponentMale() {
        if(!isMaleSelected){
            viewMale.setCardBackgroundColor((getColor(R.color.background_component_selected)))
            viewFemale.setCardBackgroundColor((getColor(R.color.background_component)))
            isMaleSelected = true;
            isFemaleSelected = false;
        }
    }

    private fun setColorComponentFemale() {
        if(!isFemaleSelected){
            viewFemale.setCardBackgroundColor((getColor(R.color.background_component_selected)))
            viewMale.setCardBackgroundColor((getColor(R.color.background_component)))
            isMaleSelected = false;
            isFemaleSelected = true;
        }
    }
    private fun setWeight(){
        tvWeight.text = currentWeight.toString();
    }

    private fun setAge(){
        tvAge.text = currentAge.toString();
    }

    private fun calculateIMC() : Double{

        val df = DecimalFormat("#.##")

        return currentWeight.toDouble()/ (currentHeight.toDouble()/100*currentHeight.toDouble()/100);

    }

}