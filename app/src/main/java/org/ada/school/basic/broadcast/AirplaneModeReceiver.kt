package org.ada.school.basic.broadcast


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirplaneModeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isAirplaneModeOn = intent.getBooleanExtra("state", false)
            val message = if (isAirplaneModeOn) {
                "Airplane Mode is ON"
            } else {
                "Airplane Mode is OFF"
            }
            Log.d("AirplaneModeReceiver", message)
        }
    }
}
