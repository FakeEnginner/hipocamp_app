package com.example.hipocamp_app.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.hipocamp_app.R
import com.example.hipocamp_app.dashboardActivity
import com.example.hipocamp_app.utils.Helper

class signup: Fragment() {
    val helper = Helper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.signup, container, false)

        val creatAccount = view.findViewById<ImageView>(R.id.createaccount)
        val login = view.findViewById<TextView>(R.id.logintxt)
        creatAccount.setOnClickListener {
            val intent = Intent(requireActivity(), dashboardActivity::class.java)
            startActivity(intent)
        }
        login.setOnClickListener {
            helper?.replaceFragment(login(),requireFragmentManager())
        }


        return view
    }
}