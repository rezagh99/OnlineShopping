package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeKalaDao {
    private val kala_list = mutableListOf<Kala>()
    private val kalaha = MutableLiveData<List<Kala>>()

    init {
        kalaha.value = kala_list
    }

    fun addKala(kala: Kala) {
        kala_list.add(kala)
        kalaha.value = kala_list
    }

    fun getKalaha() = kalaha as LiveData<List<Kala>>

    fun getKala(id: Int): Kala {
        return this.kala_list[id]
    }
}