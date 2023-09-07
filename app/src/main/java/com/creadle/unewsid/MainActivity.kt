package com.creadle.unewsid

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.creadle.unewsid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameArray = resources.getStringArray(R.array.data_name)
        val descriptionArray = resources.getStringArray(R.array.data_description)
        val photoArray = resources.obtainTypedArray(R.array.data_photo)

        for (i in nameArray.indices) {
            val news = News(
                photoArray.getResourceId(i, 0),
                nameArray[i],
                descriptionArray[i]
            )
            newsList.add(news)
        }


        photoArray.recycle()


        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext,1)
            adapter = CardAdapter(newsList, mainActivity)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.aboutmenu -> {
                val moveIntent = Intent(this@MainActivity, about::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }



    override fun onClick(news: News) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(NEWS_EXTRA, news.id)
        startActivity(intent)
    }
}