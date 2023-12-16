package com.example.xvouch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xvouch.databinding.ItemGameGridBinding

class GridGameAdapter (private val gridGame : ArrayList<Game>) : RecyclerView.Adapter<GridGameAdapter.GridViewHolder> () {
    class GridViewHolder(var binding: ItemGameGridBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = ItemGameGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding)
    }

    override fun getItemCount(): Int = gridGame.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val (name, developer, price, photo) = gridGame[position]
        holder.binding.imgGamePhoto.setImageResource(photo)
        holder.binding.tvGameTitle.text = name
        holder.binding.tvDeveloper.text = developer
        holder.binding.tvPrice.text = price
    }

}