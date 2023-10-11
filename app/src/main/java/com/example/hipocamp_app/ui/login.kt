package com.example.hipocamp_app.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ContentView
import androidx.fragment.app.Fragment
import com.example.hipocamp_app.R
import com.example.hipocamp_app.utils.Helper
import com.google.android.material.bottomnavigation.BottomNavigationView

class login : Fragment(){
    val helper = Helper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login, container, false)
        val loginbtn = view.findViewById<ImageView>(R.id.Login)
        val signup = view.findViewById<TextView>(R.id.sign_up)
        val forgotpassword = view.findViewById<TextView>(R.id.forgot_pass)
        loginbtn.setOnClickListener{

           val activity = requireActivity()
            activity.setContentView(R.layout.dashboard_activity)
            helper?.replacetoDashboardFragment(dashboard(),requireFragmentManager())
        }
        signup.setOnClickListener {
            helper?.replaceFragment(signup(),requireFragmentManager())
        }
        forgotpassword.setOnClickListener {
            helper?.replaceFragment(ForgotPassword(),requireFragmentManager())
        }
        return view
    }
}