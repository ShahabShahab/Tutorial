package com.example.mahdadsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mahdadsample.Constants.EMPTY_MESSAGE
import com.example.mahdadsample.Constants.MESSAGE_KEY
import com.example.mahdadsample.Constants.SENDING_MESSAGE_RESULT_CODE_FAILURE
import com.example.mahdadsample.Constants.SENDING_MESSAGE_RESULT_CODE_SUCCESS
import kotlinx.android.synthetic.main.activity_client1.*

class Client1Activity : AppCompatActivity() {

    private var message = EMPTY_MESSAGE
    private val ON_RECEIVING_MESSAGE_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "hashCode: ${this}")
        setContentView(R.layout.activity_client1)
        if (intent.getStringExtra(MESSAGE_KEY) != null) {
            if (intent.getStringExtra(MESSAGE_KEY).isNotEmpty()) {
                message = intent.getStringExtra(MESSAGE_KEY)
            }
        }
        tvReceivedMessage.text = message
    }

    companion object {
        private const val TAG = "Client1Activity"
        fun createIntent(context: Context): Intent {
            return Intent(context, Client1Activity::class.java)
        }
    }

    fun onSendClicked(view: View) {
        Log.d(TAG, "onSendClicked: ")
        val message = etMessage?.text?.toString()
        val intent = Intent(this, Client2Activity::class.java)
        intent.putExtra(MESSAGE_KEY, message)
        startActivityForResult(intent, ON_RECEIVING_MESSAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            ON_RECEIVING_MESSAGE_REQUEST_CODE -> {
                handleResult(resultCode, data)
            }
        }
    }

    private fun handleResult(resultCode: Int, data: Intent?) {
        when (resultCode) {
            SENDING_MESSAGE_RESULT_CODE_SUCCESS -> {
                Toast.makeText(this, "Operation Succeeded", Toast.LENGTH_LONG)
                    .show()

            }
            SENDING_MESSAGE_RESULT_CODE_FAILURE -> {
                Toast.makeText(this, "Operation Failed", Toast.LENGTH_LONG)
                    .show()

            }
        }
    }
}
