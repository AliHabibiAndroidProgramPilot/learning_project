package com.example.learningproject

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.learningproject.databinding.ListItemBinding
import java.util.*
import kotlin.collections.ArrayList

class CustomAdapterRecyclerView(
    private val contextActivity: Activity,
    private val dataList: ArrayList<DataClass>
) : RecyclerView.Adapter<CustomAdapterRecyclerView.CustomViewHolder>(), Filterable {
    private val dataListFull = ArrayList<DataClass>()
    init {
        dataListFull.addAll(dataList)
    }
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
                dataListFull.removeAt(position)
                dataList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, dataListFull.size)
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
        dataListFull.add(
            DataClass(dataList.size, songName, artistNme, R.drawable.gray)
        )
        notifyItemInserted(dataList.lastIndex + 1)
    }

    override fun getFilter(): Filter =
        object: Filter() {
            override fun performFiltering(searchQuery: CharSequence?): FilterResults {
                val filterResults = ArrayList<DataClass>()
                if (searchQuery == null || searchQuery.isEmpty()) {
                    filterResults.addAll(dataListFull)
                } else {
                    val userSearchQuery = searchQuery.toString().trim()
                    for (item in dataListFull) {
                        if (item.songName.contains(userSearchQuery) || item.artistName.contains(userSearchQuery))
                            filterResults.add(item)
                    }
                }
                val finalResult = FilterResults()
                finalResult.values = filterResults
                return finalResult
            }

            @SuppressLint("NotifyDataSetChanged")
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(p0: CharSequence?, filter: FilterResults?) {
                dataList.clear()
                dataList.addAll(filter?.values as ArrayList<DataClass>)
                notifyDataSetChanged()
            }
        }
}