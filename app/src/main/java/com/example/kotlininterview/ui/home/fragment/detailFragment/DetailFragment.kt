package com.example.kotlininterview.ui.home.fragment.detailFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlininterview.R
import com.example.kotlininterview.api.Routes
import com.example.kotlininterview.di.component.DaggerFragmentComponent
import com.example.kotlininterview.di.module.FragmentModule
import com.example.kotlininterview.model.ModelDetail
import com.example.kotlininterview.ui.home.adapter.ListDetailAdapter
import kotlinx.android.synthetic.main.detail_fragment.*
import javax.inject.Inject

class DetailFragment: Fragment(), DetailContract.View {

    @Inject
    lateinit var presenter: DetailContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): DetailFragment {
        return DetailFragment()
    }

    fun showDetailsInstance(idDetail : String): DetailFragment {
        val fragment = DetailFragment()
        val args = Bundle()
        args.putString("idDetail", idDetail)
        fragment.setArguments(args)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.detail_fragment, container, false)
        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBarDetail.visibility = View.VISIBLE
        } else {
            progressBarDetail.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
    }

    override fun loadDataSuccess(detail: ModelDetail) {
        var adapter = ListDetailAdapter(context, detail.app_images.toMutableList(), this)
        app_images_recycler!!.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL ,false))
        app_images_recycler!!.setAdapter(adapter)

        detail_app_name.setText(detail.name)
        detail_app_ranking.setText(detail.average_ratings.toString())
        detail_app_long_description.setText(detail.long_desc)

    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        listComponent.inject(this)
    }

    private fun initView() {

        val args = arguments
        val idDetail = args!!.getString("idDetail", "")

        presenter.loadDetail(Routes.HEADER,idDetail)
    }

    companion object {
        val TAG: String = "DetailFragment"
    }
}