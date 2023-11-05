package com.example.hipocamp_app.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hipocamp_app.R
import com.example.hipocamp_app.ui.OnboardingScreen


class OnboardingAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val layouts = arrayOf(R.layout.onscreenjourney_1, R.layout.onscreenjourney_2, R.layout.onscreenjourney_3)

    override fun getItemCount(): Int = layouts.size

    override fun createFragment(position: Int): Fragment {
        return OnboardingScreen.newInstance(layouts[position])
    }
}