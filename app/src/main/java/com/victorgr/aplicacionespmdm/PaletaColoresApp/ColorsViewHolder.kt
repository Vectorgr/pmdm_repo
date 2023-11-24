package com.victorgr.aplicacionespmdm.PaletaColoresApp


import android.graphics.Color
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.victorgr.aplicacionespmdm.BoardgamesApp.GameCategory
import com.victorgr.aplicacionespmdm.R

class ColorsViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val tvColor: TextView = view.findViewById(R.id.tvColor)
    private val cvColor: CardView = view.findViewById(R.id.cvColor)


    fun render (color: Colors){
        tvColor.text = color.label
        //cvColor.setCardBackgroundColor(color.colorSelected)
        cvColor.setCardBackgroundColor(Color.argb(color.alpha,color.cRed,color.cGreen,color.cBlue));

    }

}