package org.ada.school.basic.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.ada.school.basic.R
import org.ada.school.basic.databinding.MainActivityBinding
import org.ada.school.basic.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.returnToMainActivity.setOnClickListener { finish() }
    }

}