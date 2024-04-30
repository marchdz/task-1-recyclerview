package com.marchernandez.recyclerviewlisttask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.marchernandez.recyclerviewlisttask.R

class ListAdapter(
    private var rowsList: List<Int> = emptyList(),
    private val onRowClickListener: (Int) -> Unit,
) : RecyclerView.Adapter<ListViewHolder>() {

    fun updateList(newRowsList: List<Int>) {
        val rowsListDiff = ListDiffUtil(rowsList, newRowsList)
        val result = DiffUtil.calculateDiff(rowsListDiff)
        rowsList = newRowsList
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListViewHolder(layoutInflater.inflate(R.layout.item_row, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.render(rowsList[position])
        holder.itemView.setOnClickListener { onRowClickListener(position) }
    }

    override fun getItemCount(): Int = rowsList.size
}