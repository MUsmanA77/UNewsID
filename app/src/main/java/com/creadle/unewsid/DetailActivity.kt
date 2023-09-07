package com.creadle.unewsid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.creadle.unewsid.databinding.ActivityDetailBinding

private lateinit var binding: ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsID = intent.getIntExtra(NEWS_EXTRA, -1)
        val news = newsFromID(newsID)
        if(news != null){
            binding.photo.setImageResource(news.photo)
            binding.nama.text = news.name
            binding.deskripsi.text = news.description

        }

    }

    private fun newsFromID(newsID: Int): News?
    {
        for (news in newsList){
            if(news.id == newsID)
                return news
        }
        return null
    }
}