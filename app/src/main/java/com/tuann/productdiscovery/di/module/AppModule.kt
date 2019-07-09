package com.tuann.productdiscovery.di.module

import android.app.Application
import android.content.Context
import com.tuann.productdiscovery.data.api.ProductApi
import com.tuann.productdiscovery.data.repository.ProductDataRepository
import com.tuann.productdiscovery.data.repository.ProductRepository
import com.tuann.productdiscovery.utils.rx.AppSchedulerProvider
import com.tuann.productdiscovery.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {
    @Singleton
    @Provides
    @JvmStatic
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    @JvmStatic
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Singleton
    @Provides
    @JvmStatic
    fun provideImageRepository(
        productApi: ProductApi
    ): ProductRepository = ProductDataRepository(productApi)
}