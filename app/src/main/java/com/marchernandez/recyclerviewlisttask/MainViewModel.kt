package com.marchernandez.recyclerviewlisttask

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private var _rows = MutableStateFlow<List<Int>>(emptyList())
    val rows: StateFlow<List<Int>> = _rows

    fun addRow() {
        _rows.update { it.plus(it.size + 1) }
    }

    fun doubleValueOnRowClick(position: Int) {
        _rows.update { it.toMutableList().apply { this[position] *= 2 } }
    }
}