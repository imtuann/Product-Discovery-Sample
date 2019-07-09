package com.tuann.productdiscovery.di

import android.app.Application
import com.tuann.productdiscovery.App
import com.tuann.productdiscovery.di.module.AppModule
import com.tuann.productdiscovery.di.module.DatabaseModule
import com.tuann.productdiscovery.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ViewModelModule::class,
        ActivityBindingBuilder::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): AppComponent
    }

    override fun inject(app: App)
}