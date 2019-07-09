package com.tuann.productdiscovery.di.activitybuilder

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.tuann.productdiscovery.di.ViewModelKey
import com.tuann.productdiscovery.presentation.productlisting.ProductListingActivity
import com.tuann.productdiscovery.presentation.productlisting.ProductListingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ProductListingModule {
    @Binds
    fun providesAppCompatActivity(mapsActivity: ProductListingActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ViewModelKey(ProductListingViewModel::class)
    fun bindMainViewModel(
        productListingViewModel: ProductListingViewModel
    ): ViewModel
}