package com.example.yourssu_android_mission2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.yourssu_android_mission2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_result)
        binding.lifecycleOwner=this


//        var viewModel = ViewModelProviders.of(this)[UserViewModel::class.java]
        //       binding.viewModel = viewModel

        binding.viewModel =UserViewModel()
        //binding.tvEmail.text=viewModel.getEmail()
        //binding.tvPassword.text=viewModel.getPassword()

        binding.ibnResultClose.setOnClickListener(){
            val intent = Intent(this, EmailActivity::class.java)  // 인텐트를 생성해줌,
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}