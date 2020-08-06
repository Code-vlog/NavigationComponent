package com.goodwilldev.navigationcomponent.second_

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {
    private var text: MutableLiveData<String> = MutableLiveData()

    fun setText(text: String) {
        this.text.postValue(text)
    }

    fun getText(): LiveData<String> {
        return text
    }
}