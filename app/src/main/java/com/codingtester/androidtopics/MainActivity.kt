package com.codingtester.androidtopics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingtester.androidtopics.databinding.ActivityMainBinding
import com.codingtester.androidtopics.ui.intent.IntentActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIntent.setOnClickListener {
            startActivity(Intent(this, IntentActivity::class.java))
        }

    }

}