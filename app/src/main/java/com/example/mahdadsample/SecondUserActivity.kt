package com.example.mahdadsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second_user.*

class SecondUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_user)
        val receivedMessage = intent.getStringExtra("MESSAGE_KEY")
        tvResponse.text = receivedMessage
    }

    companion object {
        private const val TAG = "SecondUserActivity"
        fun createIntent(context: Context): Intent {
            return Intent(context, SecondUserActivity::class.java)
        }
    }

    fun onSendClicked(view: View) {
        val message = etMessage.text.toString()
        val intent = Intent(this, FirstUserActivity::class.java)
        intent.putExtra("MESSAGE_KEY", message)
        startActivity(intent)
        finish()
    }
}
