package com.example.hipocamp_app.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.example.hipocamp_app.R

class developer_option : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.developer_option, container, false)
        // Find the LottieAnimationView in the inflated layout
        val lottieAnimationView = view.findViewById<LottieAnimationView>(R.id.lottie_animation)
        // Set the animation file for the LottieAnimationView
        lottieAnimationView.setAnimation(R.raw.lottie_animation)

        return view
    }

}