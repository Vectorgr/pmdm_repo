package com.victorgr.aplicacionespmdm.GiphyApps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.victorgr.aplicacionespmdm.R

class GiphyAdapter ( var giphyList: List<GiphyItemResponse> = emptyList()) : RecyclerView.Adapter<GiphyViewHolder>() {
    fun updateList(list: List<GiphyItemResponse>) {
        giphyList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiphyViewHolder {
        return GiphyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_giphy, parent, false)
        )

    }
    override fun onBindViewHolder(holder: GiphyViewHolder, position: Int) {
        holder.bind(giphyList[position])

    }
    override fun getItemCount() = giphyList.size
}
