package com.tuann.productdiscovery.data.api

import com.tuann.productdiscovery.data.api.response.Result
import com.tuann.productdiscovery.data.api.response.SearchProduct
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {

    @GET("search")
    fun getProducts(
        @Query("channel") channel: String,
        @Query("visitorId") visitorId: String,
        @Query("q") q: String,
        @Query("terminal") terminal: String,
        @Query("_page") page: Int
    ): Single<Result<SearchProduct>>

    @GET("products/{product_sku}")
    fun getProduct(
        @Path("product_sku") sku: String
    )
}