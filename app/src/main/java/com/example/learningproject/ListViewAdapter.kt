package com.example.learningproject

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.learningproject.databinding.ListItemBinding

class ListViewAdapter(
    private val context: Activity,
    private val item: Array<DataProduct>
) : ArrayAdapter<DataProduct>(
    context,
    R.layout.list_item,
    item
) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ListItemBinding.inflate(context.layoutInflater)
        binding.txtName.text = item[position].name
        binding.txtPrice.text = item[position].Price
        binding.imageView.setImageResource(item[position].imgAddress)
        return binding.root
    }
}