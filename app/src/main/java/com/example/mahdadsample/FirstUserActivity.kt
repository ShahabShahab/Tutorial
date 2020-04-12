package com.example.mahdadsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first_user.etMessage
import kotlinx.android.synthetic.main.activity_first_user.tvResponse

class FirstUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_user)
        val receivedMessage = intent.getStringExtra("MESSAGE_KEY")
        tvResponse.text = receivedMessage
    }

    companion object {
        private const val TAG = "FirstUserActivity"
        fun createIntent(context: Context): Intent {
            return Intent(context, FirstUserActivity::class.java)
        }
    }

    fun onSendClicked(view: View) {
        Log.d(TAG, "onSendClicked: ")
        val message = etMessage.text.toString()
        val intent = Intent(this, SecondUserActivity::class.java)
        intent.putExtra("MESSAGE_KEY", message)
        startActivity(intent)
    }
}
