package com.victorgr.aplicacionespmdm.GiphyApps

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.victorgr.aplicacionespmdm.databinding.ItemGiphyBinding

class GiphyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemGiphyBinding.bind(view)

    fun bind(giphyItemResponse: GiphyItemResponse) {
        binding.tvGiphyName.text = giphyItemResponse.title
        binding.tvGiphyDate.text = giphyItemResponse.import_datetime
        binding.tvGiphyUsername.text = giphyItemResponse.username

        Picasso.get().load(giphyItemResponse.images.original.url).into(binding.ivGiphy)
    }
}
