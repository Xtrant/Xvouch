package com.example.xvouch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xvouch.databinding.ProfilListBinding

class ListProfileAdapter(private val listProfile: ArrayList<Profil>) : RecyclerView.Adapter<ListProfileAdapter.ListViewHolder>(){
    class ListViewHolder(var binding: ProfilListBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ProfilListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listProfile.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (logo, judul, isi) = listProfile[position]
        holder.binding.logo.setImageResource(logo)
        holder.binding.title.text = judul
        holder.binding.isi.text = isi
    }
}
