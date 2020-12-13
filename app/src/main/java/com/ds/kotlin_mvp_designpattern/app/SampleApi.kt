package com.ds.kotlin_mvp_designpattern.app

import com.ds.kotlin_mvp_designpattern.data.response.EmployeeRespose
import retrofit2.Call
import retrofit2.http.GET

interface SampleApi {


    @GET("v1/employees")
    fun getEmpList():Call<EmployeeRespose>
}