package com.tuann.productdiscovery.di

import com.tuann.productdiscovery.di.activitybuilder.ProductDetailModule
import com.tuann.productdiscovery.di.activitybuilder.ProductListingModule
import com.tuann.productdiscovery.presentation.productdetail.ProductDetailActivity
import com.tuann.productdiscovery.presentation.productlisting.ProductListingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingBuilder {

    @ContributesAndroidInjector(
        modules = [
            ProductListingModule::class
        ]
    )
    fun contributeProductListing(): ProductListingActivity

    @ContributesAndroidInjector(
        modules = [
            ProductDetailModule::class
        ]
    )
    fun contributeProductDetail(): ProductDetailActivity
}