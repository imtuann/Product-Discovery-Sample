package com.tuann.productdiscovery.presentation.productlisting

import com.tuann.productdiscovery.data.model.Product

sealed class ProductListingState {
    object Loading : ProductListingState()
    class ShowError(val message: String?) : ProductListingState()
    class Success(val products: List<Product>) : ProductListingState()
}