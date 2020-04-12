package com.example.mahdadsample

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_implicit_intents.*

class ImplicitIntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)
    }

    companion object {
        private const val TAG = "ImplicitIntentsActivity"
        fun createIntent(context: Context): Intent {
            return Intent(context, ImplicitIntentsActivity::class.java)
        }
    }

    fun onOpenWebsiteClicked(view: View) {
        val websiteUrl = etWebsite.text.toString()
        val callIntent: Intent = Uri.parse("tel:$websiteUrl").let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        startActivity(callIntent)
    }
}
