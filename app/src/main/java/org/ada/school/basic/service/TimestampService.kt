package org.ada.school.basic.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class TimestampService : Service() {

    private lateinit var handlerThread: HandlerThread
    private lateinit var handler: Handler

    override fun onCreate() {
        super.onCreate()
        handlerThread = HandlerThread("TimestampServiceThread").apply { start() }
        handler = Handler(handlerThread.looper)
        handler.post(runnable)
    }

    private val runnable = object : Runnable {
        override fun run() {
            logTimestamp()
            handler.postDelayed(this, 5000) // 5 seconds delay
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
        handlerThread.quitSafely()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null // We are not binding this service to an activity
    }

    private fun logTimestamp() {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val timestamp = sdf.format(Date())
        Log.d("TimestampService", "Current Timestamp: $timestamp")
    }
}
