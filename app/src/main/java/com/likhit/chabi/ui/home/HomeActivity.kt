package com.likhit.chabi.ui.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.likhit.chabi.R
import com.likhit.chabi.base.BaseActivity
import com.likhit.chabi.databinding.ActivityHomeBinding


class HomeActivity : BaseActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
}