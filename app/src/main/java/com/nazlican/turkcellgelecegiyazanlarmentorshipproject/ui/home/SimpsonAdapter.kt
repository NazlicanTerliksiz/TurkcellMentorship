package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.model.SimpsonModel
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.databinding.ItemViewCharacterBinding
import com.squareup.picasso.Picasso

class SimpsonAdapter(
private val quoteList: List<SimpsonModel>,
) : RecyclerView.Adapter<SimpsonAdapter.SimpsonViewHolder>() {

    inner class SimpsonViewHolder(val binding: ItemViewCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpsonViewHolder {
        val binding =
            ItemViewCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimpsonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    override fun onBindViewHolder(holder: SimpsonViewHolder, position: Int) {
        val quote = quoteList[position]

        Picasso.get().load(quote.image).into(holder.binding.ivCharacter)

        holder.binding.tvCharacter.text = quote.character
    }
}
