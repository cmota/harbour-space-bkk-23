package com.harbourspace.unsplash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

  private var _number: Int = 0
  val number = MutableLiveData<Int>()

  fun increment() {
    _number++
    number.postValue(_number)
  }
}
