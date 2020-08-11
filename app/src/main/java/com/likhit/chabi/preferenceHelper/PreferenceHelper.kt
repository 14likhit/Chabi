package com.likhit.chabi.preferenceHelper

import android.content.Context
import android.content.SharedPreferences
import com.firebase.ui.auth.data.model.User
import com.google.gson.Gson


/**
 * Singleton Class for Shared Preference Utilities.
 */
object PreferenceHelper {

    private const val PREF_APP_NAME = "app_pref_name_1414"

    private const val KEY_USER = "USER"
    private const val KEY_FIREBASE_USER_ID = "FIREBASE_USER_ID"

    private lateinit var sharedPreferences: SharedPreferences

    fun initializePreferenceHelper(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            PREF_APP_NAME,
            Context.MODE_PRIVATE
        )
    }

    @Synchronized
    fun saveUser(user: User?) {
        val gson = Gson()
        val editor = sharedPreferences.edit()
        editor.putString(KEY_USER, gson.toJson(user))
        editor.apply()
    }

    @Synchronized
    fun getUser(): User? {
        val gson = Gson()
        return gson.fromJson(
            sharedPreferences.getString(KEY_USER, null),
            User::class.java
        )
    }

    @Synchronized
    fun saveFirebaseUid(firebaseUid: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_FIREBASE_USER_ID, firebaseUid)
        editor.apply()
    }

    @Synchronized
    fun getFirebaseUid(): String? {
        return sharedPreferences.getString(KEY_FIREBASE_USER_ID, null)
    }

}