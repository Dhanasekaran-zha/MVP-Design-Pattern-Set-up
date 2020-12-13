package com.ds.kotlin_mvp_designpattern.base

interface BasePresenter<in V : BaseView> {
    fun setView(view: V)

    fun destroyView()

    fun destroy()
}