package com.creadle.unewsid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.creadle.unewsid.databinding.CardCellBinding

class CardAdapter(
    private val newsList: List<News>,
    private val clickListener: ClickListener
): RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)
        return CardViewHolder(binding,clickListener)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindNews(newsList[position])
    }
}