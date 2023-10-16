package com.example.hipocamp_app.utils

import android.annotation.SuppressLint
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.hipocamp_app.R
import timber.log.Timber

class Helper {

    fun replaceFragment(fragment: Fragment, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    @SuppressLint("SuspiciousIndentation")
    fun replacetoDashboardFragment(fragment: Fragment,fragmentManager: FragmentManager){
            fragmentManager.beginTransaction()
                .replace(R.id.dashboard_container,fragment)
                .addToBackStack("null")
                .commit()
    }

}