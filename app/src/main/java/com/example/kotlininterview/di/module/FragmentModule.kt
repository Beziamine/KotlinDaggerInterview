package com.example.kotlininterview.di.module

import com.example.kotlininterview.api.ApiServiceInterface
import com.example.kotlininterview.ui.home.fragment.detailFragment.DetailContract
import com.example.kotlininterview.ui.home.fragment.detailFragment.DetailPresenter
import com.example.kotlininterview.ui.home.fragment.listFragment.ListContract
import com.example.kotlininterview.ui.home.fragment.listFragment.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {


    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideDetailPresenter(): DetailContract.Presenter {
        return DetailPresenter()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}