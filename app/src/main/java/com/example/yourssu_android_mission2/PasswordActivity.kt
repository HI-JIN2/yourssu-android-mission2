package com.example.yourssu_android_mission2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.yourssu_android_mission2.databinding.ActivityPasswordBinding
import java.util.regex.Pattern

class PasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordBinding
    var pw: String = ""
    var email:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = intent.getStringExtra("email").toString()

        if (pw.isNotEmpty())//비었으면 not stoke
            binding.etPw.setBackgroundResource(R.drawable.shape_edittext)
        else //채웠으면 stoke
            binding.etPw.setBackgroundResource(R.drawable.shape_edittext_okay)

        val pwPattern =  "^(?=.*[A-Za-z])(?=.*\\d)[!-~₩]{8,100}$"
        val pattern2 = Pattern.compile(pwPattern) // 패턴 컴파일
        val matcher2 = pattern2.matcher(pw)

        if (!matcher2.find()) {//규칙에 안맞으면 빨간 stoke
            binding.etPw.setBackgroundResource(R.drawable.shape_edittext_not)
            binding.btnPwNext.isEnabled = false
        } else {
            binding.btnPwNext.isEnabled = true
        }

        binding.btnPwNext.isEnabled = false

        binding.etPw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pw = binding.etPw.text.toString()

                if (pw.isNotEmpty())
                    binding.etPw.setBackgroundResource(R.drawable.shape_edittext)
                else
                    binding.etPw.setBackgroundResource(R.drawable.shape_edittext_not)

                binding.btnPwNext.isEnabled = pw.isNotEmpty() //있다면 true 없으면 false
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.ibnDelete.setOnClickListener(){
            binding.etPw.text.clear()
        }

        binding.ibnClose.setOnClickListener(){
            val intent = Intent(this, EmailActivity::class.java)  // 인텐트를 생성해줌,
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }

        binding.btnPwNext.setOnClickListener() {
            val intent = Intent(this, ResultActivity::class.java)  // 인텐트를 생성해줌,
            intent.putExtra("pw", pw)
            intent.putExtra("email", email)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}