package com.likhit.chabi.utils

import android.app.Activity
import android.content.Intent
import com.likhit.chabi.ui.home.HomeActivity
import com.likhit.chabi.ui.splash.SplashActivity

fun launchSplashActivity(activity: Activity) {
    val intent = Intent(activity, SplashActivity::class.java)
    activity.startActivity(intent)
}

fun launchHomeActivity(activity: Activity) {
    val intent = Intent(activity, HomeActivity::class.java)
    activity.startActivity(intent)
}