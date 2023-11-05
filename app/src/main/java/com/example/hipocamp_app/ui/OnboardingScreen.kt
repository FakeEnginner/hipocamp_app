package com.example.hipocamp_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class OnboardingScreen : Fragment() {

    private var layoutResId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            layoutResId = it.getInt(ARG_Layout_ResId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutResId = requireArguments().getInt("layoutResId")
        return inflater.inflate(layoutResId, container, false)
    }
    companion object{
        private const val ARG_Layout_ResId = "layoutResId"
        fun newInstance(layoutResId: Int):OnboardingScreen{
            val fragment = OnboardingScreen()
            val args = Bundle()
            args.putInt("layoutResId",layoutResId)
            fragment.arguments =args
            return fragment
        }
    }
}