package com.example.myapplication

class FakeDatabase private constructor(){

    var kalaDao = FakeKalaDao()
        private set

    companion object {
        // single-tone
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(lock=this) {
            instance ?: FakeDatabase().also { instance = it }
        }
    }
}