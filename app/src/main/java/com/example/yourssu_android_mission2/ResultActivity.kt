package com.example.yourssu_android_mission2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yourssu_android_mission2.databinding.ActivityEmailBinding
import com.example.yourssu_android_mission2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvEmail.text=intent.getStringExtra("email")
        binding.tvPassword.text=intent.getStringExtra("pw")
    }
}