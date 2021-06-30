package com.al.explore.util

import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object NetworkUtility {

    private var connectivityManager: ConnectivityManager? = null

    fun initialize(connectivityManager: ConnectivityManager) {
        this.connectivityManager = connectivityManager
    }

    val isNetworkConnected: Boolean
        get() {
            val activeNetwork = connectivityManager?.activeNetwork
            activeNetwork?.let {
                val networkCapabilities = connectivityManager?.getNetworkCapabilities(it)

                return networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false ||
                        networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false ||
                        networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_VPN) ?: false

            }
            return false
        }
}