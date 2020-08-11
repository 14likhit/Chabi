package com.likhit.chabi

import android.app.Application
import com.likhit.chabi.preferenceHelper.PreferenceHelper
import com.likhit.chabi.utils.FirebaseAuthenticationHelper

class Chabi : Application() {

    override fun onCreate() {
        super.onCreate()

        PreferenceHelper.initializePreferenceHelper(this)
        FirebaseAuthenticationHelper.configureFirebase()
    }
}