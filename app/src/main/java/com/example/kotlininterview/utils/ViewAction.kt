package com.example.kotlininterview.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

object ViewAction {

     fun addFragment(activity : Activity, fragment: Fragment, frameId: Int, tag: String){
        val fragmentManager = (activity as FragmentActivity).supportFragmentManager
        fragmentManager.beginTransaction()
            .add(frameId, fragment, tag)
            .addToBackStack(tag)
            .commit()

    }

    fun replaceFragment(activity : Activity,fragment: Fragment, frameId: Int, tag: String){
        val fragmentManager = (activity as FragmentActivity).supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(frameId, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }

}