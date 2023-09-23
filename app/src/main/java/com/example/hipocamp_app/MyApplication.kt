package com.example.hipocamp_app

import android.app.Application
import com.example.hipocamp_app.BuildConfig
import android.os.Build
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

