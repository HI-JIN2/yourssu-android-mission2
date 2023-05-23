package com.example.yourssu_android_mission2

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel() {
    var userEmail : ObservableField<String> = ObservableField()
    var userPassword : ObservableField<String> = ObservableField()

    //var user : ObservableField<User> = MutableLiveData()
/*
    init{
        //user.value?.email =""
        //user.value?.password =""

        userEmail=""
        userPassword.value=""
    }
    //(MySharedPreferences.getUserId(this).isBlank()
    fun setEmail(inputEmail : String){
        //MySharedPreferences.setUserEmail(App.context(), inputEmail)
        userEmail = inputEmail
    }

    fun setPassword(inputPassword: String) {
        //MySharedPreferences.setUserPw(App.context(), inputPassword)
        userPassword = inputPassword
    }

    fun getEmail(): String? {
        return userEmail
        //MySharedPreferences.getUserId(App.context())
    }

    fun getPassword(): String? {
        return userPassword
        //MySharedPreferences.getUserPw(App.context())
    }*/
}