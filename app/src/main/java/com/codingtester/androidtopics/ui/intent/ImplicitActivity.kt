package com.codingtester.androidtopics.ui.intent

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codingtester.androidtopics.databinding.ActivityImplicitBinding

class ImplicitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImplicitBinding

    companion object {
        const val YOUTUBE_PACKAGE_NAME = "com.google.android.youtube"
        const val WEBSITE_LINK = "https://www.google.com"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplicitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBrowser.setOnClickListener {
            openBrowser()
        }

        binding.btnEmail.setOnClickListener {
            startEmailActivity()
        }

        binding.btnYoutube.setOnClickListener {
            openYoutube()
        }

        binding.btnFacebook.setOnClickListener {
            openFacebookPage()
        }
    }

    private fun openFacebookPage() {

    }

    private fun openYoutube() {
        Intent(Intent.ACTION_MAIN).apply {
            `package` = YOUTUBE_PACKAGE_NAME //package name of youtube
            try {
                startActivity(this)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this@ImplicitActivity, "can't find youtube application!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openBrowser() {
        Intent(Intent.ACTION_VIEW, Uri.parse(WEBSITE_LINK)).apply {
            startActivity(this)
        }
    }

    private fun startEmailActivity() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("mohamed.test@gmail.com")) // list of emails will be receive this message
            putExtra(Intent.EXTRA_SUBJECT, "email subject")
            putExtra(Intent.EXTRA_TEXT, "content of my email!!")
        }

        // don't forget add queries to manifest file (open manifest to check it)
        if(intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "not able to find the Email app", Toast.LENGTH_SHORT).show()
        }
    }

}