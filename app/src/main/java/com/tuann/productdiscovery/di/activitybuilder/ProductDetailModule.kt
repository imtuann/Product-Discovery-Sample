package com.tuann.productdiscovery.di.activitybuilder

import androidx.appcompat.app.AppCompatActivity
import com.tuann.productdiscovery.presentation.productdetail.ProductDetailActivity
import dagger.Binds
import dagger.Module

@Module
interface ProductDetailModule {
    @Binds
    fun providesAppCompatActivity(productDetailActivity: ProductDetailActivity): AppCompatActivity
}