package com.example.mahdadsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mahdadsample.Constants.EMPTY_MESSAGE
import com.example.mahdadsample.Constants.MESSAGE_KEY
import com.example.mahdadsample.Constants.SENDING_MESSAGE_RESULT_CODE_FAILURE
import com.example.mahdadsample.Constants.SENDING_MESSAGE_RESULT_CODE_SUCCESS
import kotlinx.android.synthetic.main.activity_client1.*

class Client2Activity : AppCompatActivity() {

    private var message = EMPTY_MESSAGE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "hashCode: ${this}")
        setContentView(R.layout.activity_client1)
        extractIntentInfo()
        tvReceivedMessage.text = message
    }

    private fun extractIntentInfo() {
        Log.d(TAG, "extractIntentInfo: ")
        if (intent.getStringExtra(MESSAGE_KEY) != null) {
            if (intent.getStringExtra(MESSAGE_KEY).isNotEmpty())
                message = intent.getStringExtra(MESSAGE_KEY)
        }
    }


    fun onSendClicked(view: View) {
        val intent = Intent()
        val message = etMessage.text.toString()
        intent.putExtra(MESSAGE_KEY, message)
        if (message == "shahab") {
            setResult(SENDING_MESSAGE_RESULT_CODE_SUCCESS, intent)
        } else {
            setResult(SENDING_MESSAGE_RESULT_CODE_FAILURE, intent)
        }
        finish()
    }

    companion object {
        private const val TAG = "Client2Activity"
        fun createIntent(context: Context): Intent {
            return Intent(context, Client2Activity::class.java)
        }
    }
}
