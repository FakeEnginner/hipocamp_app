package com.example.hipocamp_app

import android.app.Application
import android.os.Build
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
            Timber.plant(Timber.DebugTree())
    }
}


