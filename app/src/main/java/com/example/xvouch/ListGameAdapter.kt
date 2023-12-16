package com.example.xvouch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xvouch.databinding.ItemGameVoucherBinding

class ListGameAdapter(private val listGame: ArrayList<Game>) : RecyclerView.Adapter<ListGameAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemGameVoucherBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemGameVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listGame.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, developer, price, photo) = listGame[position]
        holder.binding.imgGamePhoto.setImageResource(photo)
        holder.binding.tvGameTitle.text = name
        holder.binding.tvDeveloper.text = developer
        holder.binding.tvPrice.text = price

    }
}