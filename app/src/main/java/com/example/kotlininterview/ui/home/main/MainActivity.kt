package com.example.kotlininterview.ui.home.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import com.example.kotlininterview.R
import com.example.kotlininterview.di.component.DaggerActivityComponent
import com.example.kotlininterview.di.module.ActivityModule
import com.example.kotlininterview.ui.home.fragment.detailFragment.DetailFragment
import com.example.kotlininterview.ui.home.fragment.listFragment.ListFragment
import javax.inject.Inject

class MainActivity: AppCompatActivity(), MainContract.View {

    @Inject lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }

    override fun showDetailListFragment() {
        if (supportFragmentManager.findFragmentByTag(DetailFragment.TAG) == null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.frame, DetailFragment().newInstance(), DetailFragment.TAG)
                .commit()
        }
    }

    override fun showListFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frame, ListFragment().newInstance(), ListFragment.TAG)
            .commit()
    }


    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentById(R.id.frame)

        if (fragment is ListFragment) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack(DetailFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }
}
