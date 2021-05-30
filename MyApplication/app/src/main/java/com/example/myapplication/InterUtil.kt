package com.example.myapplication

import com.example.myapplication.KalaRepository
import com.example.myapplication.FakeDatabase
import com.example.myapplication.KalaViewModelStore

object InterUtil {

    fun provideKalaViewModelStore(): KalaViewModelStore {
        val kalaRepository = KalaRepository.getInstance(FakeDatabase.getInstance().kalaDao)
        return KalaViewModelStore(kalaRepository)
    }
}