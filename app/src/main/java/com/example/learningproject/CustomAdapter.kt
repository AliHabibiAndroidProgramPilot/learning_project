package com.example.learningproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                ClickFragment()
            }
            1 -> {
                AppNameFragment()
            }
            2 -> {
                TodoFragment()
            }
            else -> { ClickFragment() }
        }
    }

}