package com.example.learningproject

import android.app.Activity
import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningproject.databinding.ListItemBinding

class CustomAdapterRecyclerView(
    private val contextActivity: Activity,
    private val dataList: List<DataClass>
) : RecyclerView.Adapter<CustomAdapterRecyclerView.CustomViewHolder>() {
    inner class CustomViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        public fun setData(dataClass: DataClass) {
            binding.txtSongName.text = dataClass.songName
            binding.txtArtistName.text = dataClass.artistName
            binding.btnListen.setOnClickListener {
                contextActivity.startActivity(
                    Intent(contextActivity, MainActivity2::class.java)
                        .putExtra("SongName", dataClass.songName)
                        .putExtra("ArtisName", dataClass.artistName)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
        CustomViewHolder(
            ListItemBinding.inflate(contextActivity.layoutInflater, parent, false)
        )

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.setData(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}