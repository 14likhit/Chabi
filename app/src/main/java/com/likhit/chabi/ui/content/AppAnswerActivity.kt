package com.likhit.chabi.ui.content

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.likhit.chabi.R
import com.likhit.chabi.adapter.AppAnswerStepRecyclerAdapter
import com.likhit.chabi.base.BaseActivity
import com.likhit.chabi.databinding.ActivityAppAnswerBinding

/**
 * Activity for Answer of a question.
 */
class AppAnswerActivity : BaseActivity() {

    private lateinit var binding: ActivityAppAnswerBinding
    private var appAnswerStepRecyclerAdapter: AppAnswerStepRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_app_answer)
        initView()
    }

    private fun initView() {
        if (appAnswerStepRecyclerAdapter == null) {
            appAnswerStepRecyclerAdapter = AppAnswerStepRecyclerAdapter()
        }

        binding.answerStepsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.answerStepsRecyclerView.adapter = appAnswerStepRecyclerAdapter
    }
}