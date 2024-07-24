package com.example.learningproject

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.KeyEvent
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (isConnected())
            setWebView()
        else
            showDialogError()
    }

    override fun onResume() {
        super.onResume()
        if (!isConnected())
            showDialogError()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebView() {
        binding.progressBar.visibility = View.VISIBLE
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.setSupportZoom(true)
        binding.webView.loadUrl("https://bitpin.ir/academy/")
        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progressBar.visibility = View.INVISIBLE
            }

            @Deprecated("Deprecated in Java")
            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                binding.progressBar.visibility = View.INVISIBLE
                showDialogError()
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            true
        } else
            super.onKeyDown(keyCode, event)
    }

    private fun showDialogError() {
        val dialog = AlertDialog.Builder(this)
        dialog.setIcon(R.drawable.ic_error)
        dialog.setTitle("Failed to load website")
        dialog.setMessage("Failed to load website this might be due to Internet Connection or problem related to website")
        dialog.setNeutralButton("Setting") { _, _ ->
            startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
            onResume()

        }
        dialog.setPositiveButton("Retry") { _, _ ->
            recreate()
        }
        dialog.setNegativeButton("Exit") { _, _ ->
            finishAffinity()
        }
        dialog.create().show()
    }

    private fun isConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }
}