package com.likhit.chabi.ui.content

import android.os.Bundle
import com.likhit.chabi.R
import com.likhit.chabi.base.BaseActivity

/**
 * Activity for list of questions of an app.
 */
class AppQuestionsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_questions)
    }
}