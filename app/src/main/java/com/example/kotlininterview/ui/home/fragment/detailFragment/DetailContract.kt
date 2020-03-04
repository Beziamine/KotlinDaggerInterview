package com.example.kotlininterview.ui.home.fragment.detailFragment

import com.example.kotlininterview.model.ModelDetail
import com.example.kotlininterview.ui.home.base.BaseContract

class DetailContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(detail: ModelDetail)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadDetail(Authorization : String, idDetail : String)
    }
}