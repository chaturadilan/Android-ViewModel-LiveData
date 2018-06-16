package me.dilan.viewmodellivedata.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    val user: MutableLiveData<User> = MutableLiveData()
    private var timerStarted: Boolean = false

    fun startLifeTimer() {
        if (!timerStarted) {
            Thread({
                for (i in 1..100) {
                    user.postValue(User("Dilan", i))
                    Thread.sleep(1000)
                }
            }).start()
        }

        timerStarted = true
    }
}