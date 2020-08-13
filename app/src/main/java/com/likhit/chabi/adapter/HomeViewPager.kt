package com.likhit.chabi.adapter

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.likhit.chabi.R
import com.likhit.chabi.ui.bookmarks.BookMarkFragment
import com.likhit.chabi.ui.chat.ChatFragment
import com.likhit.chabi.ui.home.HomeFragment
import com.likhit.chabi.ui.profile.ProfileFragment

class HomeViewPager(private val fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val mFragmentList: MutableList<Fragment> =
        arrayListOf()
    private val mFragmentTitleList: MutableList<String> =
        arrayListOf()
    private val mFragmentIconList: MutableList<Int> = arrayListOf()

    fun addFragment() {
        mFragmentList.add(HomeFragment.newInstance())
        mFragmentTitleList.add("Home")
        mFragmentIconList.add(R.drawable.ic_home)
        //todo->Commenting bookmark thing for now.
//        mFragmentList.add(BookMarkFragment.newInstance())
//        mFragmentTitleList.add("Bookmarks")
//        mFragmentIconList.add(R.drawable.ic_bookmark)
        mFragmentList.add(ChatFragment.newInstance())
        mFragmentTitleList.add("Chat")
        mFragmentIconList.add(R.drawable.ic_chat)
        mFragmentList.add(ProfileFragment.newInstance())
        mFragmentTitleList.add("Profile")
        mFragmentIconList.add(R.drawable.ic_person)
    }

    override fun getItemCount(): Int {
        return mFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun getTabView(position: Int): View? {
        val view: View =
            LayoutInflater.from(fragmentActivity).inflate(R.layout.layout_item_main_tab, null)
        val tabTextView = view.findViewById<TextView>(R.id.item_main_tab_text_view)
        tabTextView.text = mFragmentTitleList[position]
        val tabImageView =
            view.findViewById<ImageView>(R.id.item_main_tab_image_view)
        tabImageView.setImageResource(mFragmentIconList[position])
        return view
    }
}