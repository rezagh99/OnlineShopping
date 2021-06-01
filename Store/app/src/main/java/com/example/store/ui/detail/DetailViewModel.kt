package com.example.store.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.random.model.data.repository.HomeDataRepository
import com.example.store.model.entity.Product

class DetailViewModel : ViewModel() {

    private val mutableSelectedProduct= MutableLiveData<Product>()
    val selectedProduct: LiveData<Product> get() = mutableSelectedProduct

    fun selectProduct(product: Product) {
        mutableSelectedProduct.value = HomeDataRepository.getProductByName(product.name)
    }

}