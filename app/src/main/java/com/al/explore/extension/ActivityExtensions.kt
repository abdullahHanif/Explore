package com.al.explore.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


fun AppCompatActivity.addFragment(
    containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = true,
    clearBackStack: Boolean = false
) {
    if (clearBackStack) {
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
    }

    supportFragmentManager.transact {
        add(containerId, fragment)
        if (addToBackStack)
            addToBackStack(fragment::class.simpleName)
    }
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commitAllowingStateLoss()
}

