package com.likhit.chabi.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.likhit.chabi.R
import com.likhit.chabi.base.BaseFragment
import com.likhit.chabi.databinding.FragmentProfileBinding
import com.likhit.chabi.utils.FirebaseAuthenticationHelper

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentProfileBinding

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
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews(view: View) {
        super.initViews(view)
        setViewForUser()
    }

    private fun setViewForUser() {
        if (FirebaseAuthenticationHelper.checkUserLoggedIn()) {
            setUpChatView()
        } else {
            setUpSignInView()
        }
    }

    private fun setUpSignInView() {
        binding.signInButton.setOnClickListener {
            FirebaseAuthenticationHelper.launchUserAuthenticationUI(this)
        }
        toggleView(false)
    }

    private fun setUpChatView() {
        toggleView(true)
    }

    private fun toggleView(isUserLoggedIn: Boolean) {
        binding.signInButton.visibility = if (isUserLoggedIn) View.GONE else View.VISIBLE
        binding.profileLayout.profileNestedScrollView.visibility =
            if (isUserLoggedIn) View.VISIBLE else View.GONE
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFrgament.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}