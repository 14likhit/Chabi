package com.likhit.chabi.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.likhit.chabi.R
import com.likhit.chabi.preferenceHelper.PreferenceHelper

/**
 * Singleton class for firebaseAuthenticationUtilities.
 */

object FirebaseAuthenticationHelper {

    private lateinit var mFirebaseAuth: FirebaseAuth
    private var mFirebaseUser: FirebaseUser? = null

    // Choose authentication providers
    private val providers: List<AuthUI.IdpConfig> = listOf(
        AuthUI.IdpConfig.GoogleBuilder().build()
    )

    fun configureFirebase() {
        mFirebaseAuth = FirebaseAuth.getInstance()
        mFirebaseUser = mFirebaseAuth.currentUser
    }

    fun checkUserLoggedIn(): Boolean {
        val storedUser = PreferenceHelper.getFirebaseUid()
        return storedUser != null
    }

    fun isUserAuthenticated(): Boolean = mFirebaseUser != null

    fun launchUserAuthenticationUI(activity: Activity) {
        activity.startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.drawable.ic_logo)
                .setTheme(R.style.LoginTheme)
                .build(),
            RC_SIGN_IN
        )
    }

    fun launchUserAuthenticationUI(fragment: Fragment) {
        fragment.startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.drawable.ic_logo)
                .setTheme(R.style.LoginTheme)
                .build(),
            RC_SIGN_IN
        )
    }

    fun getLoggedInUser() = mFirebaseUser

    fun logOutAuthentication(activity: Activity) {
        AuthUI.getInstance()
            .signOut(activity)
            .addOnCompleteListener {
                // ...
            }
    }

    fun saveFirebaseUser() {
        mFirebaseUser = mFirebaseAuth.currentUser
        PreferenceHelper.saveFirebaseUid(mFirebaseUser?.uid)
    }

}