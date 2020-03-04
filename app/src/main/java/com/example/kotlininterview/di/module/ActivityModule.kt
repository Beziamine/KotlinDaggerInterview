package com.example.kotlininterview.di.module

import android.app.Activity
import com.example.kotlininterview.ui.home.main.MainContract
import com.example.kotlininterview.ui.home.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}