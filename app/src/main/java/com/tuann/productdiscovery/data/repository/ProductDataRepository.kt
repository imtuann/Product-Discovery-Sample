package com.tuann.productdiscovery.data.repository

import com.tuann.productdiscovery.data.api.ProductApi
import com.tuann.productdiscovery.data.api.response.mapper.toProduct
import com.tuann.productdiscovery.data.api.response.mapper.toProducts
import com.tuann.productdiscovery.data.model.Product
import io.reactivex.Single
import javax.inject.Inject

class ProductDataRepository @Inject constructor(
    private val api: ProductApi
) : ProductRepository {

    override fun getProducts(
        channel: String,
        visitorId: String,
        q: String,
        terminal: String,
        page: Int
    ): Single<List<Product>> {
        return api.getProducts(channel, visitorId, q, terminal, page)
            .map {
                return@map it.result?.products?.toProducts()
            }
    }

    override fun getProduct(sku: String): Single<Product> {
        return api.getProduct(sku)
            .map {
                return@map it.result?.product?.toProduct()
            }
    }
}