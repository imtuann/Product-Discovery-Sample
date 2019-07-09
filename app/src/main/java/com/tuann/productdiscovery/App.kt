package com.tuann.productdiscovery

import com.tuann.productdiscovery.di.DaggerAppComponent
import com.tuann.productdiscovery.di.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule())
            .build()
    }
}