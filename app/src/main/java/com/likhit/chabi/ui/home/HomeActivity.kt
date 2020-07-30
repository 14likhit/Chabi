package com.likhit.chabi.ui.home

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.likhit.chabi.R
import com.likhit.chabi.adapter.HomeViewPager
import com.likhit.chabi.base.BaseActivity
import com.likhit.chabi.databinding.ActivityHomeBinding


class HomeActivity : BaseActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setUpTabLayout()
    }

    private fun setUpTabLayout() {
        val pagerAdapter = HomeViewPager(this@HomeActivity)
        pagerAdapter.addFragment()
        activityHomeBinding.homeViewPager.adapter = pagerAdapter

        TabLayoutMediator(activityHomeBinding.homeTabLayout, activityHomeBinding.homeViewPager)
        { tab, position ->

        }.attach()

        val porterDuffColorFilterSelected = PorterDuffColorFilter(
            resources.getColor(R.color.colorPrimary),
            PorterDuff.Mode.SRC_ATOP
        )

        val porterDuffColorFilterUnselected = PorterDuffColorFilter(
            resources.getColor(R.color.tab_unselected),
            PorterDuff.Mode.SRC_ATOP
        )

        activityHomeBinding.homeTabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            var isTabSelected = false
            override fun onTabReselected(tab: TabLayout.Tab?) {
                if (!isTabSelected) {
                    setTabSelectedView(tab, porterDuffColorFilterSelected)
                    isTabSelected = true
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                setTabUnselectedView(tab, porterDuffColorFilterUnselected)
                isTabSelected = false
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                setTabSelectedView(tab, porterDuffColorFilterSelected)
                isTabSelected = true
            }
        })
        // Iterate over all tabs and set the custom view
        for (i in 0 until activityHomeBinding.homeTabLayout.tabCount) {
            val tab = activityHomeBinding.homeTabLayout.getTabAt(i)
            tab?.customView = pagerAdapter.getTabView(i)
        }

        activityHomeBinding.homeTabLayout.selectTab(activityHomeBinding.homeTabLayout.getTabAt(0))
    }

    private fun setTabUnselectedView(
        tab: TabLayout.Tab?,
        porterDuffColorFilterUnselected: PorterDuffColorFilter
    ) {
        val view = tab!!.customView
        if ((view as ViewGroup).children.elementAt(0) is AppCompatImageView) {
            val image: AppCompatImageView =
                view.children.elementAt(0) as AppCompatImageView
            image.colorFilter = porterDuffColorFilterUnselected
        }
        if (view.children.elementAt(1) is AppCompatTextView) {
            val text: AppCompatTextView =
                view.children.elementAt(1) as AppCompatTextView
            text.setTextColor(resources.getColor(R.color.colorThirdText))
        }
    }

    private fun setTabSelectedView(
        tab: TabLayout.Tab?,
        porterDuffColorFilterSelected: PorterDuffColorFilter
    ) {
        val view = tab!!.customView
        if ((view as ViewGroup).children.elementAt(0) is AppCompatImageView) {
            val image: AppCompatImageView =
                view.children.elementAt(0) as AppCompatImageView
            image.colorFilter = porterDuffColorFilterSelected
        }
        if (view.children.elementAt(1) is AppCompatTextView) {
            val text: AppCompatTextView =
                (view as ViewGroup).children.elementAt(1) as AppCompatTextView
            text.setTextColor(resources.getColor(R.color.colorPrimary))
        }
    }
}