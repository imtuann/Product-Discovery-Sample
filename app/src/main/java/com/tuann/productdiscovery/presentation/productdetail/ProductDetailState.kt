package com.tuann.productdiscovery.presentation.productdetail

import com.tuann.productdiscovery.data.model.Product

sealed class ProductDetailState {
    object Loading : ProductDetailState()
    class ShowError(val message: String?) : ProductDetailState()
    class Success(val product: Product) : ProductDetailState()
}