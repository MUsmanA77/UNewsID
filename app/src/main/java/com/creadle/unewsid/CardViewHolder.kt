package com.creadle.unewsid

import androidx.recyclerview.widget.RecyclerView
import com.creadle.unewsid.databinding.CardCellBinding

class CardViewHolder(
    private  val cardCellBinding: CardCellBinding,
    private val clickListener: ClickListener
):RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindNews(news: News)
    {
        cardCellBinding.photo.setImageResource(news.photo)
        cardCellBinding.name.text = news.name
        cardCellBinding.description.text=news.description

        cardCellBinding.cardView.setOnClickListener(){
            clickListener.onClick(news)
        }
    }
}