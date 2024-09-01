package com.example.learningproject

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.learningproject.databinding.ListLayoutBinding

class CountryListAdapter(
    private val contextActivity: Activity,
    private val array: Array<CountryDataClass>
    ) : ArrayAdapter<CountryDataClass>(
    contextActivity,
    R.layout.list_layout,
    array
) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ListLayoutBinding.inflate(contextActivity.layoutInflater)
        binding.imgCountry.setImageResource(array[position].countryImage)
        binding.txtCountryName.text = array[position].countryName
        binding.txtCountryContinent.text = array[position].countryContinent
        return binding.root
    }
}