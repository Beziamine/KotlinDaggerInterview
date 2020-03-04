package com.example.kotlininterview.ui.home.fragment.listFragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlininterview.R
import com.example.kotlininterview.api.Routes
import com.example.kotlininterview.di.component.DaggerFragmentComponent
import com.example.kotlininterview.di.module.FragmentModule
import com.example.kotlininterview.model.Model
import com.example.kotlininterview.ui.home.adapter.ListAdapter
import com.example.kotlininterview.ui.home.fragment.detailFragment.DetailFragment
import com.example.kotlininterview.ui.home.main.MainActivity
import com.example.kotlininterview.utils.ViewAction
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class ListFragment: Fragment(), ListContract.View, ListAdapter.onItemClickListener {

    @Inject
    lateinit var presenter: ListContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): ListFragment {
        return ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_main, container, false)
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
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
    }

    override fun loadDataSuccess(list: List<Model>) {
        var adapter = ListAdapter(context, list.toMutableList(), this)
        recyclerView!!.setLayoutManager(LinearLayoutManager(activity))
        recyclerView!!.setAdapter(adapter)
    }


    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        listComponent.inject(this)
    }

    private fun initView() {
        presenter.loadData(Routes.HEADER)
    }

    override fun itemDetail(postId: String) {

        val fragment = DetailFragment().showDetailsInstance(postId)
        ViewAction.replaceFragment(activity!!,fragment,R.id.frame,DetailFragment.TAG)

    }

    companion object {
        val TAG: String = "ListFragment"
    }
}