package com.example.yourssu_android_mission2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yourssu_android_mission2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email=intent.getStringExtra("email")
        binding.tvEmail.text= "$email@soongsil.ac.kr"
        binding.tvPassword.text=intent.getStringExtra("pw")

        binding.ibnResultClose.setOnClickListener(){
            val intent = Intent(this, EmailActivity::class.java)  // 인텐트를 생성해줌,
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}