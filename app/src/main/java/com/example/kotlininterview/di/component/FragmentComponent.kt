package com.example.kotlininterview.di.component

import com.example.kotlininterview.di.module.FragmentModule
import com.example.kotlininterview.ui.home.fragment.detailFragment.DetailFragment
import com.example.kotlininterview.ui.home.fragment.listFragment.ListFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(listFragment: ListFragment)

    fun inject(detailFragment: DetailFragment)

}