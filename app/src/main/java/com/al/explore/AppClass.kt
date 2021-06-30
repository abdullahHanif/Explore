package com.al.explore

import android.app.Application
import android.net.ConnectivityManager
import com.al.explore.util.NetworkUtility
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AppClass : Application() {

    @Inject
    lateinit var connectivityManager: ConnectivityManager

    override fun onCreate() {
        super.onCreate()

        NetworkUtility.initialize(connectivityManager)

    }
}

