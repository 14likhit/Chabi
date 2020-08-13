package com.likhit.chabi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likhit.chabi.databinding.LayoutAnswerCardBinding

/**
 * Adapter for App Answer list.
 */
class AppAnswerStepRecyclerAdapter :
    RecyclerView.Adapter<AppAnswerStepRecyclerAdapter.AppAnswerStepViewHolder>() {

    //todo->Add list holder for App Question List.

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AppAnswerStepViewHolder {
        return AppAnswerStepViewHolder(
            LayoutAnswerCardBinding.inflate(
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
        holder: AppAnswerStepViewHolder,
        position: Int
    ) {
    }

    class AppAnswerStepViewHolder(val binding: LayoutAnswerCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}