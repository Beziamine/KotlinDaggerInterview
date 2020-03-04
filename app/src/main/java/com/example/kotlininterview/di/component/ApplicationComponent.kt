package com.example.kotlininterview.di.component

import com.example.kotlininterview.BaseApp
import com.example.kotlininterview.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}