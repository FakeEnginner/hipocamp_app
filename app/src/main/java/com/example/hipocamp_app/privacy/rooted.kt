package com.example.hipocamp_app.privacy

import java.io.File

class rooted {

    fun isRootedDevice(): Boolean{
        return checkSystemProperty() || checkSuperUserApk() || checkRootFiles()
    }

    fun checkSystemProperty(): Boolean{
        val buildTags = android.os.Build.TAGS
        return buildTags != null && buildTags.contains("test-keys")
    }

    fun checkSuperUserApk(): Boolean{
        val rootPath = "/system/app/Superuser.apk"
        return File(rootPath).exists()
    }

    fun checkRootFiles(): Boolean{
        val placesToCheck = arrayOf(
            "/system/bin/su",
            "/system/xbin/su",
            "/sbin/su",
            "/system/su",
            "/system/bin/.ext/.su"
        )

        for (path in placesToCheck) {
            if (File(path).exists()) {
                return true
            }
        }

        return false
    }

}