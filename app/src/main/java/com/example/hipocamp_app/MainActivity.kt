package com.example.hipocamp_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.hipocamp_app.privacy.developerOption
import com.example.hipocamp_app.privacy.rooted
import com.example.hipocamp_app.ui.login.login
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    var rooted = rooted()
    var developerOption: developerOption = developerOption()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val developerOptionsEnabled =developerOption.isDeveloperOptionsEnabled(applicationContext)
        //root check condition
        if(!rooted.isRootedDevice()){
            //Developer option check
            Timber.tag("developer_option").e("${developerOptionsEnabled}")
            if(developerOptionsEnabled){
                Timber.tag("Developeroption").e("Developer option is On")
            }
            else {
                var login: login = login()
                replaceFragment(login)
                Timber.tag("Developeroption").e("Developer option is Off")
                Timber.tag("PhoneStatus").e("Phone is not Rooted")

            }
        }else {
            Timber.tag("PhoneStatus").e("Phone is Rooted")
        }

    }



    //changing fragment
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack("null").commit()
    }

}