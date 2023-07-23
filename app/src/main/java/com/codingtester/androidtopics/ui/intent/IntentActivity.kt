package com.codingtester.androidtopics.ui.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingtester.androidtopics.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExplicitIntent.setOnClickListener {
            Intent(this, ExplicitActivity::class.java).apply {
                this.putExtra("name","mohamed")
                this.putExtra("pass","123456")
                startActivity(this)
            }
        }

        binding.btnImplicitIntent.setOnClickListener {
            Intent(this, ImplicitActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnIntentFilter.setOnClickListener {
            Intent(this, IntentFilterActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}