package com.example.hipocamp_app

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.hipocamp_app.ui.chat
import com.example.hipocamp_app.ui.community
import com.example.hipocamp_app.ui.dashboard
import com.example.hipocamp_app.ui.expert
import com.example.hipocamp_app.utils.Helper
import com.google.android.material.bottomnavigation.BottomNavigationView

class dashboardActivity :  AppCompatActivity(){
    val helper = Helper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)
        //default fragment
        helper.replacetoDashboardFragment(dashboard(), supportFragmentManager)

        // bottom sheet navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    helper.replacetoDashboardFragment(dashboard(),supportFragmentManager)
                    true
                }
                R.id.chat -> {
                    helper.replacetoDashboardFragment(chat(),supportFragmentManager)
                    true
                }
                R.id.community -> {
                    helper.replacetoDashboardFragment(community(),supportFragmentManager)
                    true
                }
                R.id.expert -> {
                    helper.replacetoDashboardFragment(expert(),supportFragmentManager)
                    true
                }
                else -> false
            }
        }
    }


}