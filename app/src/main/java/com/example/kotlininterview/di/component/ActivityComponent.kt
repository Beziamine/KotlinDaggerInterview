package com.example.kotlininterview.di.component

import com.example.kotlininterview.ui.home.main.MainActivity
import com.example.kotlininterview.di.module.ActivityModule
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}