package com.example.myapplication

import androidx.lifecycle.ViewModel

class KalaViewModel(private val kalaRepository: KalaRepository): ViewModel() {

    fun getKalaha() = kalaRepository.getKalaha()

    fun addKala(kala: Kala) = kalaRepository.addKala(kala)

    fun initializeFakeData() {
        val kala1: Kala = Kala("Table", 2000.0, company = "IKEA", type_of = "Metal", colour = "Gray");
        val kala2: Kala = Kala("Shirt", 90.0, company = "LC-Waikiki", type_of = "T-Shirt", colour = "Yellow");


        this.addKala(kala1)
        this.addKala(kala2)

    }

}