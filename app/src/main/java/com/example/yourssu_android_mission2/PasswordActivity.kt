package com.example.yourssu_android_mission2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.yourssu_android_mission2.databinding.ActivityEmailBinding
import com.example.yourssu_android_mission2.databinding.ActivityPasswordBinding

class PasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordBinding
    var pw: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //버튼 비활성화
        binding.btnPwNext.isEnabled = false

        //EditText 값 있을때만 버튼 활성화
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

        binding.btnPwNext.setOnClickListener() {
            val intent = Intent(this, ResultActivity::class.java)  // 인텐트를 생성해줌,
            intent.putExtra("pw", pw)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}