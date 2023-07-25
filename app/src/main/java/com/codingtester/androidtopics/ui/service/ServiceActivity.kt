package com.codingtester.androidtopics.ui.service

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.codingtester.androidtopics.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity(), TextBackgroundService.ServiceInterface {

    private lateinit var binding: ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }

        binding.btnStartForeground.setOnClickListener {
            Intent(this, ForegroundService::class.java).apply {
                this.action = ForegroundService.ServiceStatus.START.toString()
                startService(this)
            }
        }

        binding.btnStopForeground.setOnClickListener {
            Intent(this, ForegroundService::class.java).apply {
                this.action = ForegroundService.ServiceStatus.STOP.toString()
                stopService(this)
            }
        }

        binding.btnTextBackgroundService.setOnClickListener {
            binding.progress.visibility = View.VISIBLE
            binding.txtText.visibility = View.GONE

            TextBackgroundService.serviceInterface = this
            Intent(this, TextBackgroundService::class.java).apply {
                startService(this)
            }
        }

        binding.btnStartBackgroundSound.setOnClickListener {
            Intent(this, SoundBackgroundService::class.java).apply {
                startService(this)
            }
        }

        binding.btnStopBackgroundSound.setOnClickListener {
            Intent(this, SoundBackgroundService::class.java).apply {
                stopService(this)
            }
        }
    }

    override fun writeAfterDelay(text: String) {
        binding.progress.visibility = View.GONE
        binding.txtText.visibility = View.VISIBLE
        binding.txtText.text = text
    }
}
