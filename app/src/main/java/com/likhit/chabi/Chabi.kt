package com.likhit.chabi

import android.app.Application
import com.likhit.chabi.utils.FirebaseAuthenticationHelper

class Chabi : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseAuthenticationHelper.configureFirebase()
    }
}