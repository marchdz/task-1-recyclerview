package com.marchernandez.recyclerviewlisttask.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.marchernandez.recyclerviewlisttask.databinding.ItemRowBinding

class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemRowBinding.bind(view)

    fun render(number: Int) {
        binding.tvRowNumber.text = number.toString()
    }
}