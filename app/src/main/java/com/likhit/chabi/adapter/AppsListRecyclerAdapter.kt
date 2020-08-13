package com.likhit.chabi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likhit.chabi.custom.OnItemClickListener
import com.likhit.chabi.data.AppQuestion
import com.likhit.chabi.databinding.LayoutItemAppCardBinding

/**
 * Adapter for Apps list.
 */
class AppsListRecyclerAdapter(val onItemClickListener: OnItemClickListener<AppQuestion>) :
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
        holder.binding.appCardView.setOnClickListener {
            onItemClickListener.onItemClick(AppQuestion(), position, it)
        }
    }

    class AppsListViewHolder(val binding: LayoutItemAppCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}