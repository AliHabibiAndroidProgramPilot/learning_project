package com.example.learningproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.learningproject.databinding.RecyclerViewItemBinding

class RecyclerAdapter(private val count: Int) : RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(binding: RecyclerViewItemBinding) :
        ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
        CustomViewHolder(
            RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = count

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {}


}