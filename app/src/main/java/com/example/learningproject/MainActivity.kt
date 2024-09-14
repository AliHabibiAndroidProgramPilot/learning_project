package com.example.learningproject

import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CustomAdapterRecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val data = arrayListOf(
            DataClass(1, "Video Game", "Lana Del Ray", R.drawable.gray),
            DataClass(2, "Amen", "Drake", R.drawable.gray),
            DataClass(3, "RedSky", "21 Savage", R.drawable.gray),
            DataClass(5, "Sorrow", "Pink Floyd", R.drawable.gray),
            DataClass(6, "Disco", "Surface", R.drawable.gray),
            DataClass(7, "Sinner Man", "Nina Simone", R.drawable.gray),
            DataClass(8, "Comfortably Numb", "Pink Floyd", R.drawable.gray),
            DataClass(9, "Blue Sky", "Pink Floyd", R.drawable.gray),
            DataClass(10, "Rich Spirit", "Kendrick Lamar", R.drawable.gray),
            DataClass(11, "Persian Rug", "PARTYNEXTDOOR", R.drawable.gray),
            DataClass(12, "SunFlower", "Post Malone", R.drawable.gray),
            DataClass(13, "Young Lust", "Pink Floyd", R.drawable.gray)
        )
        adapter = CustomAdapterRecyclerView(this, data)
        binding.RecyclerView.adapter = adapter
        binding.RecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.btnAdd.setOnClickListener {
            adapter.addItem(
                binding.edtSongName.text.toString(),
                binding.edtArtistName.text.toString()
            )
            binding.edtSongName.text.clear()
            binding.edtArtistName.text.clear()
        }
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                adapter.moveItem(fromPosition, toPosition)
                return true
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int){}
       /*     override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val swipeFlag = 0
                val dragFlagsUp = ItemTouchHelper.UP
                val dragFlagsDown = ItemTouchHelper.DOWN
            }

            override fun isItemViewSwipeEnabled(): Boolean = false*/
        }).attachToRecyclerView(binding.RecyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val item = menu?.findItem(R.id.action_search)
        val searchView: SearchView? = item?.actionView as SearchView?


        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(submitQuery: String?): Boolean {
                adapter.filter.filter(submitQuery)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
        return true
    }
}