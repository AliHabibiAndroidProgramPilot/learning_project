package com.example.learningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var isFloatingClicked = false
        // Put Extended Floating Action Button in Shrink mode
        binding.floatingActionButton.shrink()
        binding.floatingActionButton.setOnClickListener {
            // Play with "isFloatingClicked" Variable to Hide And Show Buttons
            isFloatingClicked = if (isFloatingClicked) {
                binding.floatingActionButton.shrink()
                hideButtons()
                false
            } else {
                binding.floatingActionButton.extend()
                showButtons()
                true
            }
        }
        // Manage Buttons to Hide When Clicked
        // By Using hideAfterClicked() Function And Put It On "isFloatingClicked" Variable
        binding.shareButton.setOnClickListener {
            isFloatingClicked = hideAfterClicked()
        }
        binding.deleteButton.setOnClickListener {
            isFloatingClicked = hideAfterClicked()
        }
        binding.addButton.setOnClickListener {
            isFloatingClicked = hideAfterClicked()
        }
    }

    private fun hideAfterClicked(): Boolean {
        // Shrink, Hide Buttons and Send False State to "isFloatingClicked" Variable
        binding.floatingActionButton.shrink()
        hideButtons()
        return false
    }

    private fun showButtons() {
        // Show Buttons Using show()
        binding.addButton.show()
        binding.deleteButton.show()
        binding.shareButton.show()
    }

    private fun hideButtons() {
        // Hide Buttons Using hide()
        binding.addButton.hide()
        binding.deleteButton.hide()
        binding.shareButton.hide()
    }
}