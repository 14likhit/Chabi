package com.likhit.chabi.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.likhit.chabi.R
import com.likhit.chabi.databinding.ActivitySplashBinding
import com.likhit.chabi.utils.launchHomeActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var activitySplashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        startTimer()
    }

    private fun startTimer() {
        activitySplashBinding.root.postDelayed({
            launchHomeActivity(this@SplashActivity)
            finish()
        }, 250)
    }
}