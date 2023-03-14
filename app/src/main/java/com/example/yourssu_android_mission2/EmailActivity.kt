package com.example.yourssu_android_mission2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.yourssu_android_mission2.databinding.ActivityEmailBinding

class EmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailBinding

    var email: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //버튼 비활성화
        binding.btnEmailNext.isEnabled = false

        //EditText 값 있을때만 버튼 활성화
        binding.etEmail.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                email = binding.etEmail.text.toString()

                if (email.isNotEmpty())
                    binding.etEmail.setBackgroundResource(R.drawable.shape_edittext)
                else
                    binding.etEmail.setBackgroundResource(R.drawable.shape_edittext_not)

                binding.btnEmailNext.isEnabled = email.isNotEmpty() //있다면 true 없으면 false
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.btnEmailNext.setOnClickListener() {
            val intent = Intent(this, PasswordActivity::class.java)  // 인텐트를 생성해줌,
            intent.putExtra("email", email)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}