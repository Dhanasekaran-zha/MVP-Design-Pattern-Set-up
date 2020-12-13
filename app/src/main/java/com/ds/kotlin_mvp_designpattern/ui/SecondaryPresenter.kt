package com.ds.kotlin_mvp_designpattern.ui

import com.ds.kotlin_mvp_designpattern.app.AppController
import com.ds.kotlin_mvp_designpattern.base.AbstractBasePresenter
import com.ds.kotlin_mvp_designpattern.data.response.EmployeeRespose
import com.ds.kotlin_mvp_designpattern.utils.UiUtils

class SecondaryPresenter: AbstractBasePresenter<SecondaryView>() {
    private var secondaryView:SecondaryView?=null

    override fun setView(view: SecondaryView) {
        super.setView(view)
        secondaryView=view
        adminRepo=AppController.getInstanse()!!.getAdminRepo()
    }

    override fun onResponse(responseParser: Any) {
        super.onResponse(responseParser)
        secondaryView!!.hideLoading()
        var list=(responseParser as EmployeeRespose).datas
        secondaryView!!.employeeList(list!!)

    }

    override fun onFailure(message: String) {
        super.onFailure(message)
        UiUtils.showToast(secondaryView!!.context(),message)
        secondaryView!!.hideLoading()
    }

    fun getEmployeeListApi(){
        secondaryView!!.showLoading()
        adminRepo!!.getEmployeeList(this)
    }
}