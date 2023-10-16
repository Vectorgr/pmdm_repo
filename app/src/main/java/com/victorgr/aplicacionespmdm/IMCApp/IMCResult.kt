package com.victorgr.aplicacionespmdm.IMCApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.victorgr.aplicacionespmdm.R
import java.text.DecimalFormat

class IMCResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcresult)

        var result: Double? = intent.extras?.getDouble("result")
        var tvResult = findViewById<TextView>(R.id.tvResult)

        var df = DecimalFormat("#.##")
        tvResult.text = df.format(result);

    }
}