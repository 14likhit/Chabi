package com.likhit.chabi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.likhit.chabi.adapter.AppsListRecyclerAdapter
import com.likhit.chabi.base.BaseFragment
import com.likhit.chabi.custom.OnItemClickListener
import com.likhit.chabi.data.AppQuestion
import com.likhit.chabi.databinding.FragmentHomeBinding
import com.likhit.chabi.utils.launchAppQuestionsActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment(), OnItemClickListener<AppQuestion> {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentHomeBinding
    private var appsAdapter: AppsListRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews(view: View) {
        super.initViews(view)

        if (appsAdapter == null) {
            appsAdapter = AppsListRecyclerAdapter(this)
        }

        binding.homeContainerLinearLayout.app_list_recycler_view.layoutManager =
            GridLayoutManager(activity, 2)
        binding.homeContainerLinearLayout.app_list_recycler_view.adapter =
            appsAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }

    override fun onItemClick(item: AppQuestion, position: Int, view: View?) {
        launchAppQuestionsActivity(getBaseActivity()!!)
    }
}