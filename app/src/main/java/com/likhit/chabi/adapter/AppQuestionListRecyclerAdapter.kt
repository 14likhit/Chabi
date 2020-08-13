package com.likhit.chabi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likhit.chabi.databinding.LayoutItemQuestionBinding

/**
 * Adapter for App Questions list.
 */
class AppQuestionListRecyclerAdapter :
    RecyclerView.Adapter<AppQuestionListRecyclerAdapter.AppQuestionListViewHolder>() {

    //todo->Add list holder for App Question List.

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AppQuestionListViewHolder {
        return AppQuestionListViewHolder(
            LayoutItemQuestionBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(
        holder: AppQuestionListViewHolder,
        position: Int
    ) {
    }

    class AppQuestionListViewHolder(val binding: LayoutItemQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}