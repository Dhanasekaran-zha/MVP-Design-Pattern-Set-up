package com.ds.kotlin_mvp_designpattern.ui

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ds.kotlin_mvp_designpattern.R
import com.ds.kotlin_mvp_designpattern.base.BaseActivity
import com.ds.kotlin_mvp_designpattern.data.response.DatasItem
import kotlinx.android.synthetic.main.activity_secondary.*

class SecondaryActivity : BaseActivity(),SecondaryView {

    var presenter:SecondaryPresenter?= SecondaryPresenter()
    var empListAdapter:EmployeeListAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        rec_list.layoutManager=LinearLayoutManager(this)
        empListAdapter= EmployeeListAdapter(this)
        rec_list.adapter=empListAdapter
        presenter!!.setView(this)
        presenter!!.getEmployeeListApi()
    }

    override fun employeeList(list: List<DatasItem>) {
        empListAdapter!!.setList(list)
    }

    override fun showLoading() {
        showProgress()
    }

    override fun hideLoading() {
        hideProgress()
    }

    override fun showRetry() {
    }

    override fun hideRetry() {
    }

    override fun showError(message: String) {
    }

    override fun context(): Context {
        return this
    }
}