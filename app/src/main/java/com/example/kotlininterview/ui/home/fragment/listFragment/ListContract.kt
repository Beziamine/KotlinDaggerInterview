package com.example.kotlininterview.ui.home.fragment.listFragment

import com.example.kotlininterview.model.Model
import com.example.kotlininterview.ui.home.base.BaseContract

class ListContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData(Authorization : String)

    }
}