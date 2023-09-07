package com.creadle.unewsid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.creadle.unewsid.databinding.ActivityDetailBinding



class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val news = intent.getParcelableExtra<News>("news") // Mengambil objek News dari intent

        if (news != null) {
            binding.photo.setImageResource(news.photo)
            binding.nama.text = news.name
            binding.deskripsi.text = news.description

            binding.btnShare.setOnClickListener{
                shareNews(news)}
        }
    }


    private fun shareNews(news: News){
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            type="text/plain"
            putExtra(Intent.EXTRA_SUBJECT,news.name)
            putExtra(Intent.EXTRA_TEXT,news.description)

        }

        startActivity(Intent.createChooser(shareIntent,"Share News"))

    }
}

