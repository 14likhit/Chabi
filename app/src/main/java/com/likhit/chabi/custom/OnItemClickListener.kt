package com.likhit.chabi.custom

import android.view.View

/**
 * Generic OnItemClickListener.
 */
interface OnItemClickListener<T> {
    fun onItemClick(item: T, position: Int, view: View?)
}