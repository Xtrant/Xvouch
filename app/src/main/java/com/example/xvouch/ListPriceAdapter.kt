package com.example.xvouch

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.xvouch.databinding.PriceListBinding

class ListPriceAdapter(private val listPrice: ArrayList<Price>) :
    RecyclerView.Adapter<ListPriceAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: PriceListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = PriceListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listPrice.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (dmAmount, dmPrice) = listPrice[position]
        holder.binding.amountDm.text = dmAmount
        holder.binding.priceDm.text = dmPrice

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Will be update in next assignment",
                Toast.LENGTH_SHORT
            ).show()
        }


    }
}
