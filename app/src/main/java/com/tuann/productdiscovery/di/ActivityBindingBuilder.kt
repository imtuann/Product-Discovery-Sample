package com.tuann.productdiscovery.di

import com.tuann.productdiscovery.di.activitybuilder.ProductListingModule
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
}