package com.victorgr.aplicacionespmdm.BoardgamesApp

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.victorgr.aplicacionespmdm.R

class GamesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val cbGame : CheckBox = view.findViewById(R.id.cbGame)
    private val tvGame : TextView = view.findViewById(R.id.tvGame);


    fun render(game: Games) {
        when (game) {
            Games.Cooperative -> {
                tvGame.text = "Cooperativos"

            }

            Games.Deckbuilding -> {
                tvGame.text = "Deckbuilding"

            }

            Games.Euro -> {
                tvGame.text= "Euro"

            }

            Games.LCG -> {
                tvGame.text= "LCG"

            }

            Games.Legacy -> {
                tvGame.text= "Legacy"

            }


        }
    }
}