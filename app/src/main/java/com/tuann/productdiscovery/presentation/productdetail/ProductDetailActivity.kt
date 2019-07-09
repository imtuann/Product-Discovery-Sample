package com.tuann.productdiscovery.presentation.productdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tuann.productdiscovery.data.model.Product
import com.tuann.productdiscovery.presentation.common.BaseActivity

class ProductDetailActivity : BaseActivity() {

    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = intent.getParcelableExtra(EXTRA_PRODUCT)
    }

    companion object {
        private const val EXTRA_PRODUCT = "extra_product"

        fun newIntent(context: Context, product: Product): Intent =
            Intent(context, ProductDetailActivity::class.java)
                .apply {
                    putExtra(EXTRA_PRODUCT, product)
                }
    }
}