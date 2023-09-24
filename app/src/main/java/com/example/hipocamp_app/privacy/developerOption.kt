package com.example.hipocamp_app.privacy
import android.provider.Settings
import android.content.Context


class developerOption {
    fun isDeveloperOptionsEnabled(context: Context): Boolean {
        return Settings.Global.getInt(context.contentResolver, Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) == 1
    }
}