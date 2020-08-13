package com.likhit.chabi.ui.content

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.likhit.chabi.R
import com.likhit.chabi.adapter.AppQuestionListRecyclerAdapter
import com.likhit.chabi.base.BaseActivity
import com.likhit.chabi.databinding.ActivityAppQuestionsBinding

/**
 * Activity for list of questions of an app.
 */
class AppQuestionsActivity : BaseActivity() {

    private lateinit var binding: ActivityAppQuestionsBinding
    private var questionListRecyclerAdapter: AppQuestionListRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_app_questions)
        initView()
    }

    private fun initView() {
        if (questionListRecyclerAdapter == null) {
            questionListRecyclerAdapter = AppQuestionListRecyclerAdapter()
        }

        binding.questionListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.questionListRecyclerView.adapter = questionListRecyclerAdapter
    }
}