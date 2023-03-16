package com.example.yourssu_android_mission2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var userEmail : MutableLiveData<String> = MutableLiveData()
    var userPassword : MutableLiveData<String> = MutableLiveData()

    init{
        userEmail.value=""
        userPassword.value=""
    }

//    fun setEmail(e : String){
//        userEmail.value=e
//    }
//
//    fun setPassword(pw: String) {
//        userPassword.value=pw
//    }
}