package com.jeanbarrossilva.andre.extension

import androidx.lifecycle.MutableLiveData

object MutableLiveDataX {
    fun MutableLiveData<Boolean>.toggle(onNullValue: () -> Boolean = { false }) {
        value = value?.not() ?: onNullValue()
    }
}