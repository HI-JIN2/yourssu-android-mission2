package com.example.yourssu_android_mission2


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.example.yourssu_android_mission2.databinding.ActivityEmailBinding

class EmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailBinding
    private val liveUser =MutableLiveData<User>()

    var email: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_email)
        binding.lifecycleOwner=this

        var viewModel = ViewModelProviders.of(this)[UserViewModel::class.java]
        binding.viewModel = viewModel


        //버튼 비활성화
//        binding.btnEmailNext.isEnabled = false

        //EditText 값 있을때만 버튼 활성화
        binding.etEmail.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.userEmail = binding.etEmail.text.toString()
                email = binding.etEmail.text.toString()

//                binding.btnEmailNext.isEnabled = email.isNotEmpty() //있다면 true 없으면 false
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.btnEmailNext.setOnClickListener() {
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("email",email)
            editor.commit()

            val intent = Intent(this, PasswordActivity::class.java)  // 인텐트를 생성해줌,
            viewModel.setEmail(binding.etEmail.text.toString())
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}