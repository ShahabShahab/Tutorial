package com.example.mahdadsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bool = savedInstanceState == null
        Log.d(TAG, "onCreate: {$bool}")
        setContentView(R.layout.activity_news)
        if (savedInstanceState != null) {
            score = savedInstanceState.getInt(SCORE_KEY)
        }
        updateScoreBoard()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ")
        outState.putInt(SCORE_KEY, score)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        LogAsyncTask(tvScoreBoard).execute()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    companion object {
        private const val SCORE_KEY = "SCORE_KEY"
        private const val TAG = "NewsActivity"
        fun createIntent(context: Context): Intent {
            return Intent(context, NewsActivity::class.java)
        }
    }

    fun onDecreaseTeamScore(view: View) {
        Log.d(TAG, "onDecreaseTeamScore: ${Thread.currentThread().name}")
        if (score > 0) score--
        updateScoreBoard()
    }

    private fun updateScoreBoard() {
//        val thread = Thread(Runnable {
//            Log.d(TAG, "updateScoreBoard: ${Thread.currentThread().name}")
//        })
//        thread.start()
        tvScoreBoard.text = score.toString()
    }

    fun onIncreaseTeamScore(view: View) {
        Log.d(TAG, "onIncreaseTeamScore: ")
        score++
        updateScoreBoard()
    }
}
