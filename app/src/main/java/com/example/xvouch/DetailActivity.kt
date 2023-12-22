package com.example.xvouch

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xvouch.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var rvPrice: RecyclerView
    private val list = ArrayList<Price>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataGame = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_game", Game::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_game")
        }

        rvPrice = binding.rvPrice
        rvPrice.setHasFixedSize(true)

        if (dataGame != null) {
            binding.tvDevDetail.text = dataGame.dev
            binding.tvGameTitleDetail.text = dataGame.name
            binding.imgGameDetail.setImageResource(dataGame.photo)
            binding.mainDetailImg.setImageResource(dataGame.mainImageDetail)

        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnBuy.setOnClickListener {
            Toast.makeText(
                this,
                "Will be update in next assignment",
                Toast.LENGTH_SHORT
            ).show()
        }

        list.addAll(getListPrice())
        showRecyclerGrid()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        when (item.itemId) {
            R.id.action_share -> {
                shareContent()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == Configuration.UI_MODE_NIGHT_NO) {
            menuInflater.inflate(R.menu.menu_detail_light, menu)
        } else {
            menuInflater.inflate(R.menu.menu_detail_dark, menu)
        }
        return true
    }


    private fun getListPrice(): ArrayList<Price> {
        val dataPrice = resources.getStringArray(R.array.data_dmPriceMl)
        val dataAmount = resources.getStringArray(R.array.data_dmAmountMl)
        val listPrice = ArrayList<Price>()
        for (i in dataPrice.indices) {
            val price = Price(dataAmount[i], dataPrice[i])
            listPrice.add(price)
        }
        return listPrice

    }

    private fun showRecyclerGrid() {
        val rvPrice = binding.rvPrice
        rvPrice.layoutManager = GridLayoutManager(this, 2)
        val listPriceAdapter = ListPriceAdapter(list)
        rvPrice.adapter = listPriceAdapter
    }

    private fun shareContent() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this amazing detail!")
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

}