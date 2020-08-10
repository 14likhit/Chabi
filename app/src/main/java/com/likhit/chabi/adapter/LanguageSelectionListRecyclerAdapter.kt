package com.likhit.chabi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likhit.chabi.databinding.LayoutItemTextDividerBinding

/**
 * Adapter for language Selection list.
 */
class LanguageSelectionListRecyclerAdapter :
    RecyclerView.Adapter<LanguageSelectionListRecyclerAdapter.LanguageSelectionListViewHolder>() {

    //todo->Add list holder for Language List.

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LanguageSelectionListViewHolder {
        return LanguageSelectionListViewHolder(
            LayoutItemTextDividerBinding.inflate(
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
        holder: LanguageSelectionListViewHolder,
        position: Int
    ) {
    }

    class LanguageSelectionListViewHolder(val binding: LayoutItemTextDividerBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}