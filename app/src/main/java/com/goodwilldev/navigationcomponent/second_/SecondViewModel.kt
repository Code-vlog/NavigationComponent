package com.goodwilldev.navigationcomponent.second_

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {
    private var name: MutableLiveData<String> = MutableLiveData()

    fun setName(name: String) {
        this.name.postValue(name)
    }

    fun getName(): LiveData<String> {
        return name
    }
}