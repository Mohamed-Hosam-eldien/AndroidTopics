package com.codingtester.androidtopics.ui.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper

class TextBackgroundService : Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Handler(Looper.getMainLooper()).postDelayed({
            serviceInterface?.writeAfterDelay("this text was written by background service")
        }, 3000)
        return START_STICKY
    }

    companion object {
        var serviceInterface: ServiceInterface? = null
    }

    interface ServiceInterface {
        fun writeAfterDelay(text: String)
    }
}