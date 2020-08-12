package com.likhit.chabi.ui.chat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.firebase.ui.database.SnapshotParser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.likhit.chabi.base.BaseFragment
import com.likhit.chabi.data.FirebaseMessage
import com.likhit.chabi.databinding.FragmentChatBinding
import com.likhit.chabi.databinding.LayoutMessageSenderItemBinding
import com.likhit.chabi.utils.FirebaseAuthenticationHelper
import com.likhit.chabi.utils.RC_SIGN_IN

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val MESSAGES_CHILD = "messages"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentChatBinding

    private lateinit var mFirebaseDatabaseReference: DatabaseReference
    private lateinit var mFirebaseAdapter: FirebaseRecyclerAdapter<FirebaseMessage, MessageSenderViewHolder>
    private var mLinearLayoutManager: LinearLayoutManager? = null

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
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews(view: View) {
        super.initViews(view)

        setViewForUser()
    }

    override fun onPause() {
        mFirebaseAdapter.stopListening()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        mFirebaseAdapter.startListening()
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
        setUpFirebaseDatabase()
        mLinearLayoutManager = LinearLayoutManager(getBaseActivity())
        mLinearLayoutManager!!.stackFromEnd = true
        binding.chatLayout.chatMessagesRecyclerView.layoutManager = mLinearLayoutManager
        binding.chatLayout.chatMessagesRecyclerView.adapter = mFirebaseAdapter
        setUpMessageEnterLayout()
        toggleView(true)
    }

    private fun setUpMessageEnterLayout() {
        binding.chatLayout.sendButton.setOnClickListener {
            val message = FirebaseMessage(
                text = binding.chatLayout.messageEditText.text.toString(),
                name = "Likhit"
            )
            mFirebaseDatabaseReference.child(MESSAGES_CHILD).push().setValue(message)
            binding.chatLayout.messageEditText.setText("")
        }
    }

    private fun setUpFirebaseDatabase() {
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().reference
        val parser: SnapshotParser<FirebaseMessage>? = SnapshotParser() { it ->
            val friendlyMessage =
                it.getValue(FirebaseMessage::class.java)
            if (friendlyMessage != null) {
                friendlyMessage.id = it.key!!
            }
            friendlyMessage!!
        }

        val messagesRef = mFirebaseDatabaseReference.child(MESSAGES_CHILD)

        val options =
            FirebaseRecyclerOptions.Builder<FirebaseMessage>().setQuery(messagesRef, parser!!)
                .build()

        setFirebaseAdapter(options)

    }

    private fun setFirebaseAdapter(options: FirebaseRecyclerOptions<FirebaseMessage>) {
        mFirebaseAdapter =
            object : FirebaseRecyclerAdapter<FirebaseMessage, MessageSenderViewHolder>(options) {
                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): MessageSenderViewHolder {
                    return MessageSenderViewHolder(
                        LayoutMessageSenderItemBinding.inflate(
                            LayoutInflater.from(parent.context), parent, false
                        )
                    )
                }

                override fun onBindViewHolder(
                    holder: MessageSenderViewHolder,
                    position: Int,
                    model: FirebaseMessage
                ) {
                    holder.layoutMessageSenderItemBinding.messageTextView.text = model.text
                }

            }

        mFirebaseAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                val friendlyMessageCount = mFirebaseAdapter.itemCount
                val lastVisiblePosition =
                    mLinearLayoutManager!!.findLastCompletelyVisibleItemPosition()
                // If the recycler view is initially being loaded or the
                // user is at the bottom of the list, scroll to the bottom
                // of the list to show the newly added message.
                if (lastVisiblePosition == -1 || (positionStart >= (friendlyMessageCount - 1) &&
                            lastVisiblePosition == (positionStart - 1))
                ) {
                    binding.chatLayout.chatMessagesRecyclerView.scrollToPosition(positionStart)
                }

            }
        })

    }

    private fun toggleView(isUserLoggedIn: Boolean) {
        binding.signInButton.visibility = if (isUserLoggedIn) View.GONE else View.VISIBLE
        binding.chatLayout.chatContainerConstraintLayout.visibility =
            if (isUserLoggedIn) View.VISIBLE else View.GONE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == RC_SIGN_IN) {
            FirebaseAuthenticationHelper.saveFirebaseUser()
            setViewForUser()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            ChatFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}