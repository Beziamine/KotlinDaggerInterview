package com.example.kotlininterview.ui.home.main

import com.example.kotlininterview.ui.home.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showListFragment()
        fun showDetailListFragment()
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {
        fun onItemClick()
    }
}