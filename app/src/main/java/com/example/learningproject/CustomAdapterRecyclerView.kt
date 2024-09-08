package com.example.learningproject

import android.app.Activity
import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningproject.databinding.ListItemBinding

class CustomAdapterRecyclerView(
    private val contextActivity: Activity,
    private val dataList: ArrayList<DataClass>
) : RecyclerView.Adapter<CustomAdapterRecyclerView.CustomViewHolder>() {
    inner class CustomViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        public fun setData(dataClass: DataClass, position: Int) {
            binding.txtSongName.text = dataClass.songName
            binding.txtArtistName.text = dataClass.artistName
            binding.root.setOnClickListener {
                contextActivity.startActivity(
                    Intent(contextActivity, MainActivity2::class.java)
                        .putExtra("SongName", dataClass.songName)
                        .putExtra("ArtisName", dataClass.artistName)
                )
            }
            binding.btnDelete.setOnClickListener {
                dataList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, dataList.size)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
        CustomViewHolder(
            ListItemBinding.inflate(contextActivity.layoutInflater, parent, false)
        )

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.setData(dataList[position], position)
    }

    override fun getItemCount(): Int = dataList.size

    public fun addItem(songName: String, artistNme: String) {
        dataList.add(
            DataClass(dataList.size, songName, artistNme, R.drawable.gray)
        )
        notifyItemInserted(dataList.lastIndex + 1)
    }

}