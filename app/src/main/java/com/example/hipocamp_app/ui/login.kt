package com.example.hipocamp_app.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hipocamp_app.R

class login : Fragment(){
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
            replaceFragment(dashboard())
        }
        signup.setOnClickListener {
            replaceFragment(signup())
        }
        forgotpassword.setOnClickListener {
            replaceFragment(ForgotPassword())
        }
        return view
    }
    private fun replaceFragment(fragment: Fragment){
        fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragment)?.addToBackStack("null")?.commit()
    }
}