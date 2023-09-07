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

        populateNews()

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

    private fun populateNews() {
        val news1= News(
            R.drawable.ahmad_dahlan,
            "ahmad_dahlan1",
            "deskripsi: test text yang sangat panjang sampai harusnya tidak terlihat didepan halaman dan hanya bisa dilihat keseluruhan text nya jika buka detailnya. text ini seharusnya sudah cukup panjang untuk tidak bisa dilihat dari depan saja dan harus memencet detail untuk melihatnya."
        )
        newsList.add(news1)

        val news2= News(
            R.drawable.ahmad_dahlan,
            "ahmad_dahlan2",
            "deskripsi: test text yang sangat panjang sampai harusnya tidak terlihat didepan halaman dan hanya bisa dilihat keseluruhan text nya jika buka detailnya. text ini seharusnya sudah cukup panjang untuk tidak bisa dilihat dari depan saja dan harus memencet detail untuk melihatnya." +
                    "\na" + "\nb" + "\nc" + "\nd" + "\ne" + "\nf" + "\ng" + "\nh" +
                    "\ni" + "\nj" + "\nk" + "\nl" + "\nm" + "\nn" + "\no" + "\np" +
                    "\nq" + "\nr" + "\ns" + "\nt" + "\nu" + "\nv" + "\nw" + "\nx" +
                    "\ny" + "\nz"+
                    "\na" + "\nb" + "\nc" + "\nd" + "\ne" + "\nf" + "\ng" + "\nh" +
                    "\ni" + "\nj" + "\nk" + "\nl" + "\nm" + "\nn" + "\no" + "\np" +
                    "\nq" + "\nr" + "\ns" + "\nt" + "\nu" + "\nv" + "\nw" + "\nx" +
                    "\ny" + "\nz"
        )
        newsList.add(news2)

        val news3= News(
            R.drawable.ahmad_dahlan,
            "ahmad_dahlan3",
            "deskripsi3cek"
        )
        newsList.add(news3)

        val news4= News(
            R.drawable.ahmad_yani,
            "ahmad_yani",
            "deskripsi"
        )
        newsList.add(news4)

        val news5= News(
            R.drawable.ahmad_dahlan,
            "ahmad_yani",
            "deskripsi"
        )
        newsList.add(news5)

        val news6= News(
            R.drawable.ahmad_dahlan,
            "ahmad_dahlan",
            "deskripsi"
        )
        newsList.add(news6)

        val news7= News(
            R.drawable.ahmad_dahlan,
            "ahmad_dahlan",
            "deskripsi"
        )
        newsList.add(news7)

        val news8= News(
            R.drawable.ahmad_dahlan,
            "ahmad_dahlan",
            "deskripsi"
        )
        newsList.add(news8)

        val news9= News(
            R.drawable.ahmad_dahlan,
            "ahmad_dahlan",
            "deskripsi"
        )
        newsList.add(news9)

        val news10= News(
            R.drawable.ahmad_dahlan,
            "ahmad_dahlan",
            "deskripsi"
        )
        newsList.add(news10)


    }

    override fun onClick(news: News) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(NEWS_EXTRA, news.id)
        startActivity(intent)
    }
}