package com.ds.kotlin_mvp_designpattern.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ds.kotlin_mvp_designpattern.R
import com.ds.kotlin_mvp_designpattern.data.response.DatasItem
import com.ds.kotlin_mvp_designpattern.data.response.EmployeeRespose
import kotlinx.android.synthetic.main.item_name_list.view.*

class EmployeeListAdapter(val context: Context):RecyclerView.Adapter<EmployeeListAdapter.EmpViewHolder>() {

    private var empList:List<DatasItem>?=null

    init {
        empList=ArrayList()
    }


    fun setList(i: List<DatasItem>){
        if (i==null){
            return
        }

        empList=i
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeListAdapter.EmpViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_name_list, parent, false)
        return EmpViewHolder(view)
    }

    override fun getItemCount(): Int {
        return empList!!.size
    }

    override fun onBindViewHolder(holder: EmployeeListAdapter.EmpViewHolder, position: Int) {
        holder.bindDataToView(empList!![position])
    }

    inner class EmpViewHolder(v:View):RecyclerView.ViewHolder(v){
        var userImage = v.user_image
        var firstname = v.firstname
        var lastname = v.lastname

        fun bindDataToView(item: DatasItem) {
            firstname.text = item.employeeName
            lastname.text = item.employeeAge
        }
    }
}