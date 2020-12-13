package com.ds.kotlin_mvp_designpattern.data.repo

import com.ds.kotlin_mvp_designpattern.app.SampleApi
import com.ds.kotlin_mvp_designpattern.base.ResponseHandler
import com.ds.kotlin_mvp_designpattern.data.response.EmployeeRespose
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminRepo(sampleAPi: SampleApi) {


    private var sampleAPi: SampleApi = sampleAPi!!

    fun getEmployeeList(handler: ResponseHandler<Any>){
        val call=sampleAPi.getEmpList()
        call.enqueue((object :Callback<EmployeeRespose>{
            override fun onFailure(call: Call<EmployeeRespose>, t: Throwable) {
                handler.onFailure(t!!.message as String)
            }

            override fun onResponse(
                call: Call<EmployeeRespose>,
                response: Response<EmployeeRespose>
            ) {
                if(response.isSuccessful){
                    handler.onResponse(response.body()!!)
                }else handler.onFailure("Failure")
            }
        }))
    }





}