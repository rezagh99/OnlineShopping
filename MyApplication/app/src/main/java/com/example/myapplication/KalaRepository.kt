package com.example.myapplication

class KalaRepository private constructor(private val kalaDao: FakeKalaDao){

    fun addKala(kala: Kala){
        kalaDao.addKala(kala)
    }

    fun getKalaha() = kalaDao.getKalaha()

    companion object {
        @Volatile private var instance: KalaRepository? = null

        fun getInstance(kalaDao: FakeKalaDao) = instance ?: synchronized(lock=this) {
            instance ?: KalaRepository(kalaDao).also { instance = it }
        }
    }
}