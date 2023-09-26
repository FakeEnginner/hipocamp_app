package com.example.hipocamp_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.hipocamp_app.privacy.developerOption
import com.example.hipocamp_app.privacy.rooted
import com.example.hipocamp_app.ui.login.login
import com.example.hipocamp_app.utils.InternetConnectivity
import com.example.hipocamp_app.utils.developer_option
import com.example.hipocamp_app.utils.rooted_option
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    var rooted_ = rooted()
    var developerOption: developerOption = developerOption()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val developerOptionsEnabled =developerOption.isDeveloperOptionsEnabled(applicationContext)
        //root check condition
        if(!rooted_.isRootedDevice()){
            //Developer option check
            Timber.tag("developer_option").e("${developerOptionsEnabled}")
            if(developerOptionsEnabled){
                Timber.tag("Developeroption").e("Developer option is On")
                val developerOption = developer_option()
                replaceFragment(developerOption)
            }
            else {
                val login = login()
                replaceFragment(login)
                Timber.tag("Developeroption").e("Developer option is Off")
                Timber.tag("PhoneStatus").e("Phone is not Rooted")

            }
        }else {
            Timber.tag("PhoneStatus").e("Phone is Rooted")
            val rooted = rooted_option()
            replaceFragment(rooted)
        }

        val internetConnectivity = InternetConnectivity()
        val context = applicationContext
        if (internetConnectivity.isNetworkAvailable(context)) {
            // Internet is available
            // Perform network-related tasks here
        } else {
            // No internet connection
            // Handle the case where there is no internet connectivity
        }

    }



    //changing fragment
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack("null").commit()
    }

}