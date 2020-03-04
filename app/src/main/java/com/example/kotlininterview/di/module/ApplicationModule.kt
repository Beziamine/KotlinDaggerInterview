package com.example.kotlininterview.di.module

import android.app.Application
import com.example.kotlininterview.BaseApp
import com.example.kotlininterview.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}