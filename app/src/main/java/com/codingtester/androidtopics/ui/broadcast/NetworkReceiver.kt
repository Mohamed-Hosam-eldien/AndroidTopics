package com.codingtester.androidtopics.ui.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class NetworkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        connectivityReceiverListener?.onNetworkConnectionChanged(isNetworkAvailable(context))
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val activeNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            activeNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            activeNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

    interface ConnectivityReceiverListener {
        fun onNetworkConnectionChanged(isConnected: Boolean)
    }

    companion object {
        var connectivityReceiverListener: ConnectivityReceiverListener? = null
    }

}