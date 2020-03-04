package com.example.kotlininterview.ui.home.fragment.detailFragment

import com.example.kotlininterview.api.ApiServiceInterface
import com.example.kotlininterview.model.ModelDetail
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailPresenter: DetailContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: DetailContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: DetailContract.View) {
        this.view = view
    }


    override fun loadDetail(Authorization: String, idDetail: String) {
        var subscribe = api.getListDetail(Authorization,idDetail).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ detail: ModelDetail? ->
                view.showProgress(false)
                view.loadDataSuccess(detail!!)
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(subscribe)
    }

}