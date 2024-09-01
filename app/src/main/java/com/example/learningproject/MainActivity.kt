package com.example.learningproject

import android.app.Application
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val countryListArray = arrayOf(
            CountryDataClass(R.drawable.as_flag, "Australia", "Australia"),
            CountryDataClass(R.drawable.bol_falg, "Bolivia", "Africa"),
            CountryDataClass(R.drawable.chad_flag, "Chad", "Africa"),
            CountryDataClass(R.drawable.jama_falg, "Jamaica", "Africa"),
            CountryDataClass(R.drawable.moro_flag, "Morocco", "Africa"),
            CountryDataClass(R.drawable.nor_falg, "Norway", "Europe"),
            CountryDataClass(R.drawable.por_flag, "Portugal", "Europe"),
            CountryDataClass(R.drawable.safrica_falg, "South Africa", "Africa"),
            CountryDataClass(R.drawable.saudi_falg, "Saudi Arabia", "Asia"),
            CountryDataClass(R.drawable.fij_flag, "Fiji", "Australia"),
            CountryDataClass(R.drawable.tur_falg, "Turkey", "Asia"),
            CountryDataClass(R.drawable.vit_falg, "Vietnam", "Asia")
        )
        binding.ListView.adapter = CountryListAdapter(this, countryListArray)
    }
}