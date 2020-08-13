package com.likhit.chabi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likhit.chabi.custom.OnItemClickListener
import com.likhit.chabi.data.AppQuestion
import com.likhit.chabi.databinding.LayoutItemQuestionBinding

/**
 * Adapter for App Questions list.
 */
class AppQuestionListRecyclerAdapter(val onItemClickListener: OnItemClickListener<AppQuestion>) :
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
        holder.binding.questionCardView.setOnClickListener {
            onItemClickListener.onItemClick(AppQuestion(), position, it)
        }
    }

    class AppQuestionListViewHolder(val binding: LayoutItemQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}