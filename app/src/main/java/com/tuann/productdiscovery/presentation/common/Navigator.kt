package com.tuann.productdiscovery.presentation.common

import androidx.appcompat.app.AppCompatActivity
import com.tuann.productdiscovery.data.model.Product
import com.tuann.productdiscovery.presentation.productdetail.ProductDetailActivity
import javax.inject.Inject

class Navigator @Inject constructor(private val activity: AppCompatActivity) {

    fun navigateToProductDetailScreen(product: Product) {
        activity.startActivity(ProductDetailActivity.newIntent(activity, product))
    }
}