package com.example.random.model.data.repository
import com.example.store.model.entity.Product
import com.example.store.model.source.LocalDataBase

object HomeDataRepository {

    fun getProduct(): List<Product> {
        return LocalDataBase.selectProducts()

    }


}