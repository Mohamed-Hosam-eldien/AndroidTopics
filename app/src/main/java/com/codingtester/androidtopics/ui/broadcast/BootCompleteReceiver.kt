package com.codingtester.androidtopics.ui.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootCompleteReceiver: BroadcastReceiver() {

    // you need to set 2 things in manifest file
    // 1--> intent filter between broadcast tags to make broadcast receive boot completed from system
    // 2--> boot complete permission
    // check manifest file too see it

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(Intent.ACTION_BOOT_COMPLETED) ) {
            Toast.makeText(context, "Welcome...", Toast.LENGTH_SHORT).show()
        }
    }
}