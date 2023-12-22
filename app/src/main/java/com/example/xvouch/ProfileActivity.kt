package com.example.xvouch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xvouch.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var rvProfile: RecyclerView
    private lateinit var binding: ActivityProfileBinding
    private val list = ArrayList<Profil>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rvProfile = binding.rvList
        rvProfile.setHasFixedSize(true)

        list.addAll(getListProfil())
        showRecyclerList()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("Recycle")
    private fun getListProfil(): ArrayList<Profil> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataIsi = resources.getStringArray(R.array.data_isi)
        val dataLogo = resources.obtainTypedArray(R.array.data_logo)
        val listProfil = ArrayList<Profil>()
        for (i in dataJudul.indices) {
            val profil = Profil(dataLogo.getResourceId(i, -1), dataJudul[i], dataIsi[i])
            listProfil.add(profil)
        }
        return listProfil
    }

    private fun showRecyclerList() {
        rvProfile.layoutManager = LinearLayoutManager(this)
        val listProfilAdapter = ListProfileAdapter(list)
        rvProfile.adapter = listProfilAdapter
    }


}