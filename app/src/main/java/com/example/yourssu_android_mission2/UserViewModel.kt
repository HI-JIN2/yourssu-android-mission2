package com.example. yourssu_android_mission2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
//    var userEmail : MutableLiveData<String> = MutableLiveData()
//    var userPassword : MutableLiveData<String> = MutableLiveData()

    var user : MutableLiveData<User> = MutableLiveData()

    init{
        user.value?.email =""
        user.value?.password =""

//        userEmail.value=""
//        userPassword.value=""
    }
    //(MySharedPreferences.getUserId(this).isBlank()
    fun setEmail(inputEmail : String){
        MySharedPreferences.setUserEmail(App.context(), inputEmail)
        //user.value?.email = inputEmail
    }

    fun setPassword(inputPassword: String) {
        MySharedPreferences.setUserPw(App.context(), inputPassword)
        //user.value?.password = inputPassword
    }

    fun getEmail(): String {
        return MySharedPreferences.getUserId(App.context())
    }

    fun getPassword(): String {
        return MySharedPreferences.getUserPw(App.context())
    }
}