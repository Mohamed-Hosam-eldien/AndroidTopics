package com.codingtester.androidtopics

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingtester.androidtopics.databinding.ActivityMainBinding
import com.codingtester.androidtopics.ui.broadcast.BroadcastActivity
import com.codingtester.androidtopics.ui.intent.IntentActivity
import com.codingtester.androidtopics.ui.service.ServiceActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIntent.setOnClickListener {
            startActivity(Intent(this, IntentActivity::class.java))
        }

        binding.btnBroadcast.setOnClickListener {
            startActivity(Intent(this, BroadcastActivity::class.java))
        }

        binding.btnService.setOnClickListener {
            startActivity(Intent(this, ServiceActivity::class.java))
        }

    }
}