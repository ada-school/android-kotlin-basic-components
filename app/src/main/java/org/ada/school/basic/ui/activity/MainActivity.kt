package org.ada.school.basic.ui.activity

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.ada.school.basic.broadcast.AirplaneModeReceiver
import org.ada.school.basic.databinding.MainActivityBinding
import org.ada.school.basic.service.TimestampService

class MainActivity : AppCompatActivity() {


    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()
        registerAirplaneModeReceiver()
    }

    private fun registerAirplaneModeReceiver() {
        val airplaneModeReceiver = AirplaneModeReceiver()
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(airplaneModeReceiver, filter)
    }

    private fun setClickListeners() {

        binding.secondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.startButton.setOnClickListener {
            startService(Intent(this, TimestampService::class.java))
            binding.startButton.isEnabled = false
            binding.stopButton.isEnabled = true
            Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()
        }

        binding.stopButton.setOnClickListener {
            stopService(Intent(this, TimestampService::class.java))
            binding.startButton.isEnabled = true
            binding.stopButton.isEnabled = false
            Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()
        }
    }
}

