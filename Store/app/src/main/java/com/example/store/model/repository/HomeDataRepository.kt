package com.example.random.model.data.repository
import com.example.store.model.entity.Product
import com.example.store.model.source.LocalDataBase

object HomeDataRepository {

    fun getProduct(): List<Product> {
        return LocalDataBase.selectProducts()

    }

    fun getProductByName(name:String):Product?{
        val products=LocalDataBase.selectProducts()
        val product: Product? = products.find { it.name == name }
        return product
    }


}