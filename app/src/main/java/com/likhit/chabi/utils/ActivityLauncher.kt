package com.likhit.chabi.utils

import android.app.Activity
import android.content.Intent
import com.likhit.chabi.ui.content.AppAnswerActivity
import com.likhit.chabi.ui.content.AppQuestionsActivity
import com.likhit.chabi.ui.home.HomeActivity
import com.likhit.chabi.ui.splash.SplashActivity

/**
 * Functions for launching activities.
 */

fun launchSplashActivity(activity: Activity) {
    val intent = Intent(activity, SplashActivity::class.java)
    activity.startActivity(intent)
}

fun launchHomeActivity(activity: Activity) {
    val intent = Intent(activity, HomeActivity::class.java)
    activity.startActivity(intent)
}

fun launchAppQuestionsActivity(activity: Activity) {
    val intent = Intent(activity, AppQuestionsActivity::class.java)
    activity.startActivity(intent)
}

fun launchAppAnswerActivity(activity: Activity) {
    val intent = Intent(activity, AppAnswerActivity::class.java)
    activity.startActivity(intent)
}