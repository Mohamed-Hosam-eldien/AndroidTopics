package com.codingtester.androidtopics.ui.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class AirplaneReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {

            val turnOn = Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON
            ) != 0

            if(turnOn) {
                Toast.makeText(context, "Airplane mode enabled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Airplane mode Disabled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}