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
        setContentView(R.layout.activity_main)
        if(!rooted.isRootedDevice()){
            Timber.tag("Phonevjsd").e("Phone is not Rooted")
        }else {
            Timber.tag("Phonevjsd").e("Phone is Rooted")
        }

    }



    //changing fragment
    private fun replaceFragment(fragment: Fragment){
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_container3,fragment).addToBackStack("null").commit()
    }

}