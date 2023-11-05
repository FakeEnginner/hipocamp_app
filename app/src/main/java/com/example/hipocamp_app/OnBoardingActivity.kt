package com.example.hipocamp_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.hipocamp_app.adapter.OnboardingAdapter

class OnBoardingActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_activity)

        val viewPager : ViewPager2 = findViewById(R.id.viewpage)
        val adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter
    }
}