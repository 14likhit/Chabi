package com.likhit.chabi.ui.language

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.likhit.chabi.R
import com.likhit.chabi.adapter.LanguageSelectionListRecyclerAdapter
import com.likhit.chabi.base.BaseActivity
import com.likhit.chabi.databinding.ActivityLanguageSelectionBinding

class LanguageSelectionActivity : BaseActivity() {

    private lateinit var binding: ActivityLanguageSelectionBinding
    private var adapter: LanguageSelectionListRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_language_selection)

        initView()
    }

    private fun initView() {
        if (adapter == null) {
            adapter = LanguageSelectionListRecyclerAdapter()
        }

        binding.languageSelectionListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.languageSelectionListRecyclerView.adapter = adapter

        binding.saveButton.setOnClickListener {
            finish()
        }
    }
}