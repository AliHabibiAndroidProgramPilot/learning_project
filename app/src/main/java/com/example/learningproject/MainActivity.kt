package com.example.learningproject

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocate()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn2.setOnClickListener { changeLanguageDialog() }
    }

    private fun changeLanguageDialog() {
        val listItem = arrayOf("fa", "en")
        val alertDialog = AlertDialog.Builder(this)
        //use "getString" to pull out Strings from resources(string.xml)
        alertDialog.setTitle(resources.getString(R.string.change_language))
        alertDialog.setSingleChoiceItems(listItem, 1){ dialog, item ->
            if (item == 0) {
                setLocate(listItem[0])
                recreate()
            } else if(item == 1) {
                setLocate(listItem[1])
                recreate()
            }
            dialog.dismiss()
        }
        alertDialog.create().show()
    }
    private fun setLocate(language: String) {
        MyContextWrapper.wrap(this, language)
        resources.updateConfiguration(resources.configuration, resources.displayMetrics)
        getSharedPreferences("language", MODE_PRIVATE)
            .edit()
            .putString("savedLanguage", language)
            .apply()
    }
    private fun loadLocate() {
        val getSavedLanguagePreference = getSharedPreferences("language", MODE_PRIVATE)
        val lang = getSavedLanguagePreference.getString("language", "") ?: "en"
        setLocate(lang)
    }
}