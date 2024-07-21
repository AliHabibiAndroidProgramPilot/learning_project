package com.example.learningproject

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.Contacts
import android.provider.Settings
import android.view.View
import android.widget.Toast
import com.example.learningproject.databinding.ActivityMainBinding
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun insertContact(view: View) {
        val intent = Intent(Intent.ACTION_INSERT, Contacts.CONTENT_URI)
        intent.putExtra(ContactsContract.Intents.Insert.NAME, "Ali Habibi")
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, "09924025474")
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "app Not Found", Toast.LENGTH_LONG).show()
        }
    }
    fun sendEmail(view: View) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("biz.alihabibi@gmail.com")
            putExtra(Intent.EXTRA_SUBJECT, "Congratulations")
            putExtra(Intent.EXTRA_EMAIL, "Well Done Man you did great job")
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "$e app Not Found", Toast.LENGTH_LONG).show()
        }
    }
    fun searchInWeb(view: View) {
        val encodedQuery = URLEncoder.encode("Lionel Messi", "UTF-8")
        val url = "https://www.google.com/search?q=$encodedQuery"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "app Not Found", Toast.LENGTH_LONG).show()
        }
    }
    fun openWebPage(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.zoomit.ir/"))
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "app Not Found", Toast.LENGTH_LONG).show()
        }
    }
    fun openSetting(view: View) {
        val intent = Intent(Intent.ACTION_MAIN, Settings.System.CONTENT_URI)
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "$e app Not Found", Toast.LENGTH_LONG).show()
        }
    }
    fun dialPhoneNumber(view: View) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("09120173084"))
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "$e app Not Found", Toast.LENGTH_LONG).show()
        }
    }
    fun shareText(view: View) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Your Amazing bro")
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "$e app Not Found", Toast.LENGTH_LONG).show()
        }
    }
}