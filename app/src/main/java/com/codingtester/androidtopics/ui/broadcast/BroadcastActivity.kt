package com.codingtester.androidtopics.ui.broadcast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingtester.androidtopics.databinding.ActivityBroadcastBinding

class BroadcastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBroadcastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadcastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        

    }
}