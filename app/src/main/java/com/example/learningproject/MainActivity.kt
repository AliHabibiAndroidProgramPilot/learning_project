package com.example.learningproject

import android.annotation.SuppressLint
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
    @SuppressLint("IntentReset")
    fun sendEmail(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("biz.aliHabibi@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject")
        intent.putExtra(Intent.EXTRA_TEXT, "Email Text")
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
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        /*
            ACTION_SETTINGS
            ACTION_WIRELESS_SETTINGS
            ACTION_AIRPLANE_MODE_SETTINGS
            ACTION_WIFI_SETTINGS
            ACTION_APN_SETTINGS
            ACTION_BLUETOOTH_SETTINGS
            ACTION_DATE_SETTINGS
            ACTION_LOCALE_SETTINGS
            ACTION_INPUT_METHOD_SETTINGS
            ACTION_DISPLAY_SETTINGS
            ACTION_SECURITY_SETTINGS
            ACTION_LOCATION_SOURCE_SETTINGS
            ACTION_INTERNAL_STORAGE_SETTINGS
            ACTION_MEMORY_CARD_SETTINGS
         */
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "$e app Not Found", Toast.LENGTH_LONG).show()
        }
    }

    fun dialPhoneNumber(view: View) {
        val phoneNumber = "09120173084"
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
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