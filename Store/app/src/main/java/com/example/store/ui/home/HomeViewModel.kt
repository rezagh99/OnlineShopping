package com.example.store.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.random.model.data.repository.HomeDataRepository
import com.example.store.model.entity.Product

class HomeViewModel : ViewModel() {

    val products: MutableLiveData<List<Product>> = MutableLiveData<List<Product>>().apply {
        value = HomeDataRepository.getProduct()
    }
}