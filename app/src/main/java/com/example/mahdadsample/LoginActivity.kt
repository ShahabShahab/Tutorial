package com.example.mahdadsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bindLoginInputs(tilLoginUsername)
        bindLoginInputs(tilLoginPassword)
    }

    private fun bindLoginInputs(loginInput: TextInputLayout) {
        loginInput.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d(TAG, "onTextChanged: ${s.toString()}")
            }
        })
    }

    companion object {
        private const val TAG = "LoginActivity"
        fun createIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    fun onLoginButtonClicked(view: View) {
        Toast.makeText(this, "Button Clicked!", Toast.LENGTH_LONG)
            .show()
    }

    fun onCreateAccountClicked(view: View) {
        Log.d(TAG, "onCreateAccountClicked: ")
    }
    fun onForgetPasswordClicked(view: View) {
        Log.d(TAG, "onForgetPasswordClicked: ")
    }
}
