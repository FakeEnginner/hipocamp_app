package com.example.hipocamp_app.privacy
import android.provider.Settings
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity


class developerOption {
    fun isDeveloperOptionsEnabled(context: Context): Boolean {
        return Settings.Global.getInt(context.contentResolver, Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) == 1
    }
    private fun openDeveloperSettings(context: Context) {
        val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
        context.startActivity(intent)
    }
}