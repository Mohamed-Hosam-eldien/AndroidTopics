package com.codingtester.androidtopics.ui.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingtester.androidtopics.databinding.ActivityExplicitBinding


class ExplicitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExplicitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplicitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("name")?.let { name ->
            binding.txtName.text = name
            intent.getStringExtra("pass")?.let { pass ->
                binding.txtPass.text = pass
            }
        }
    }
}