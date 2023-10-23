package com.victorgr.aplicacionespmdm.BoardgamesApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.victorgr.aplicacionespmdm.R


class GamesAdapter(private val games: MutableList<Games>) :
    RecyclerView.Adapter<GamesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GamesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return games.size
    }
    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.render(games[position])
    }
}
