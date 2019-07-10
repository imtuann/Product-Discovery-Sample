package com.tuann.productdiscovery.data.repository

import com.tuann.productdiscovery.data.model.Product
import io.reactivex.Single

interface ProductRepository {

    fun getProducts(
        channel: String,
        visitorId: String,
        q: String,
        terminal: String,
        page: Int
    ): Single<List<Product>>

    fun getProduct(sku: String): Single<Product>
}