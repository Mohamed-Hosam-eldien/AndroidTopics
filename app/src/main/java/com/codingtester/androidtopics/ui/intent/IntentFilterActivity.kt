package com.codingtester.androidtopics.ui.intent

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codingtester.androidtopics.databinding.ActivityIntnentFilterBinding

class IntentFilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntnentFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntnentFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // here we will receive any photo will be shared to this app
        // to make this app shown in the list of apps sharing images you must set intent filter in manifest
        // (open manifest to check it)

        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
        } else {
            intent?.getParcelableExtra(Intent.EXTRA_STREAM)
        }

        Glide.with(this)
            .load(uri)
            .into(binding.image)
    }

}