package com.example.hipocamp_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.hipocamp_app.privacy.rooted
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    var rooted = rooted()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(!rooted.isRootedDevice()){
            Timber.tag("Phonevgjgv").e("Hello")
        }else {
            Timber.tag("Phonevjh").e("Baby")
        }
        setContentView(R.layout.activity_main)

    }



    //changing fragment
    private fun replaceFragment(fragment: Fragment){
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_container3,fragment).addToBackStack("null").commit()
    }

}