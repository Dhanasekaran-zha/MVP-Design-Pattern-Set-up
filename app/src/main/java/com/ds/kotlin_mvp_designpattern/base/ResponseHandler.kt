package com.ds.kotlin_mvp_designpattern.base


interface ResponseHandler<in T> {

    fun onResponse(responseParser: T)

    fun onFailure(message: String)

    fun getDataFromDB(dbData: T)



}
