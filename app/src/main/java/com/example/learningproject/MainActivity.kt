package com.example.learningproject

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = arrayListOf(
            DataClass(1, "Video Game", "Lana Del Ray", R.drawable.gray),
            DataClass(2, "Amen", "Drake", R.drawable.gray),
            DataClass(3, "RedSky", "21 Savage", R.drawable.gray),
            DataClass(4, "Sorrow", "Pink Floyd", R.drawable.gray),
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
        val adapter = CustomAdapterRecyclerView(this, data)
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
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(submitQuery: String?): Boolean {
                Toast.makeText(this@MainActivity, submitQuery, Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }
}