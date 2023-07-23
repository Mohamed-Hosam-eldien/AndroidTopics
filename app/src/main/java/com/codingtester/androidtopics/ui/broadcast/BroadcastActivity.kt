package com.codingtester.androidtopics.ui.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codingtester.androidtopics.databinding.ActivityBroadcastBinding

class BroadcastActivity : AppCompatActivity(), NetworkReceiver.ConnectivityReceiverListener {

    private lateinit var binding: ActivityBroadcastBinding
    private val airplaneModeReceiver = AirplaneReciecver()
    private val bootCompletedReceiver = BootCompleteReciever()

    companion object {
        const val CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadcastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegisterAirplane.setOnClickListener {
            registerReceiver(
                airplaneModeReceiver,
                IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            )
            Toast.makeText(this, "register airplane set", Toast.LENGTH_SHORT).show()
        }

        binding.btnUnregisterAirplane.setOnClickListener {
            try {
                unregisterReceiver(airplaneModeReceiver)
                Toast.makeText(this, "register airplane removed", Toast.LENGTH_SHORT).show()
            } catch (ex: IllegalArgumentException) {
                Toast.makeText(this, "please register receiver first", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegisterConnectivity.setOnClickListener {
            val intentFilter = IntentFilter()
            intentFilter.addAction(CONNECTIVITY_ACTION)
            registerReceiver(NetworkReceiver(), intentFilter)
            Toast.makeText(this, "register connectivity done", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        Toast.makeText(this, "network is : $isConnected", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        NetworkReceiver.connectivityReceiverListener = this
    }
}