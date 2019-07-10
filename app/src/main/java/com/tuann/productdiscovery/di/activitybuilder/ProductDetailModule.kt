package com.tuann.productdiscovery.di.activitybuilder

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.tuann.productdiscovery.di.ViewModelKey
import com.tuann.productdiscovery.presentation.productdetail.ProductDetailActivity
import com.tuann.productdiscovery.presentation.productdetail.ProductDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ProductDetailModule {
    @Binds
    fun providesAppCompatActivity(productDetailActivity: ProductDetailActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailViewModel::class)
    fun bindProductDetailViewModel(
        productDetailViewModel: ProductDetailViewModel
    ): ViewModel
}