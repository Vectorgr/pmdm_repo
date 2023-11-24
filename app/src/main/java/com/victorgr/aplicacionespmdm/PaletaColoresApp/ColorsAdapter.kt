package com.victorgr.aplicacionespmdm.PaletaColoresApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.victorgr.aplicacionespmdm.BoardgamesApp.CategoriesViewHolder
import com.victorgr.aplicacionespmdm.R

class ColorsAdapter(private val colors: List<Colors>) : RecyclerView.Adapter<ColorsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_colors, parent, false)
        return ColorsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return colors.size;
    }
    override fun onBindViewHolder(holder: ColorsViewHolder, position: Int) {
        holder.render(colors[position]);
    }
}
