package com.example.xvouch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xvouch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvGame: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Game>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detail)

        rvGame = binding.rvVoucher
        rvGame.setHasFixedSize(true)

        list.addAll(getListGame())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_list -> {
                rvGame.adapter = ListGameAdapter(list)
                rvGame.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                val gridGameAdapter = GridGameAdapter(list)
                rvGame.adapter = gridGameAdapter
                rvGame.layoutManager = GridLayoutManager(this,2)
            }
            R.id.action_about -> {
                val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(profileIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListGame(): ArrayList<Game> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDev = resources.getStringArray(R.array.data_developer)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listGame = ArrayList<Game> ()
        for (i in dataName.indices) {
            val game = Game(dataName[i], dataDev[i], dataPrice[i], dataPhoto.getResourceId(i, -1))
            listGame.add(game)
        }
        return listGame
    }

    private fun showRecyclerList() {
        rvGame.layoutManager = LinearLayoutManager(this)
        val listGameAdapter = ListGameAdapter(list)
        rvGame.adapter = listGameAdapter
    }



}