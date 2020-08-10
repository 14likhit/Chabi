package com.likhit.chabi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likhit.chabi.databinding.LayoutItemAppCardBinding

/**
 * Adapter for Apps list.
 */
class AppsListRecyclerAdapter :
    RecyclerView.Adapter<AppsListRecyclerAdapter.AppsListViewHolder>() {

    //todo->Add list holder for Apps List.

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AppsListViewHolder {
        return AppsListViewHolder(
            LayoutItemAppCardBinding.inflate(
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
        holder: AppsListViewHolder,
        position: Int
    ) {
    }

    class AppsListViewHolder(val binding: LayoutItemAppCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}