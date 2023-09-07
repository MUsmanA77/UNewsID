package com.creadle.unewsid

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
        }
    }

}