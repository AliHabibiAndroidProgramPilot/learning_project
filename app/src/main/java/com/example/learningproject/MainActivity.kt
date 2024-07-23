package com.example.learningproject

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    /**
     * @author Ali habibi
     * @see isConnected2
     * This is a methode one not to efficient but we can handle which way Internet is coming WIFI, MOBILE_NETWORK or ETHERNET
     * @return Boolean variable to detect connection
     */

    fun isConnected1(): Boolean {
        var networkState = false
        // In Activity class we don't need to use Context class to get reach to getSystemService function and CONNECTIVITY_SERVICE
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // Check if user's API level is above 23
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Safe null action by using (?:)
            val networkCapabilities = connectivityManager.activeNetwork ?: return networkState
            // Look for available connection
            val activeNetwork = connectivityManager.getNetworkCapabilities(networkCapabilities)
                ?: return networkState
            networkState = when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
            // If user's API Level wasn't above 23
        } else {
            val netInfo = connectivityManager.activeNetworkInfo
            networkState = when (netInfo!!.type) {
                ConnectivityManager.TYPE_WIFI -> true
                ConnectivityManager.TYPE_MOBILE -> true
                ConnectivityManager.TYPE_ETHERNET -> true
                else -> false
            }
        }
        return networkState
    }

    /**
     * @author Ali Habibi
     * More Efficient way to check connection
     * @return Boolean variable to detect connection
     */

    fun isConnected2(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }
}