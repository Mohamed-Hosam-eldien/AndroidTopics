package com.codingtester.androidtopics.ui.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.codingtester.androidtopics.R

class ForegroundService: Service() {

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            ServiceStatus.START.toString() -> startForegroundService()
            ServiceStatus.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForegroundService() {
        val notification = NotificationCompat.Builder(this, "our_channel_id")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Foreground Service")
            .setContentText("hello this is my foreground service")
            .build()
        startForeground(1,notification)
    }

    enum class ServiceStatus {
        START, STOP
    }
}