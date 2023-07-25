package com.codingtester.androidtopics.ui

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class TopicsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "our_channel_id",
                "topic channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}