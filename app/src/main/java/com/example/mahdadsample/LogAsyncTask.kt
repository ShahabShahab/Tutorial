package com.example.mahdadsample

import android.os.AsyncTask
import android.util.Log
import android.widget.TextView

class LogAsyncTask(val tvScoreBoard: TextView) : AsyncTask<Void, Int, String>(), Runnable {

    override fun run() {

    }

    companion object {
        private const val TAG = "LogAsyncTask"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        tvScoreBoard.text = values[0].toString()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        Log.d(TAG, "onPostExecute: ${result}")
        Log.d(TAG, "onPostExecute: ${Thread.currentThread().name}")
    }

    override fun onCancelled(result: String?) {
        super.onCancelled(result)
    }

    override fun onCancelled() {
        super.onCancelled()
    }

    override fun onPreExecute() {
        super.onPreExecute()
        Log.d(TAG, "onPreExecute: ${Thread.currentThread().name}")
    }

    override fun doInBackground(vararg params: Void?): String {
        Log.d(TAG, "doInBackground: ${Thread.currentThread().name}")
        Thread.sleep(1000L)
        publishProgress(100)
        Thread.sleep(1000L)
        publishProgress(200)
        Thread.sleep(1000L)
        publishProgress(300)
        Thread.sleep(1000L)
        publishProgress(400)
        Thread.sleep(1000L)
        publishProgress(500)
        Thread.sleep(1000L)
        publishProgress(600)
        Thread.sleep(1000L)
        publishProgress(700)
        return "Done!"
    }
}