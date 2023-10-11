package com.example.hipocamp_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hipocamp_app.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class dashboard : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dashboard, container, false)
//        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.)

        return view
    }
    private fun replaceFragment(fragment: Fragment){
        fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragment)?.addToBackStack("null")?.commit()
    }
}