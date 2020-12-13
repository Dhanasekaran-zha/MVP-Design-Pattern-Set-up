package com.ds.kotlin_mvp_designpattern.data.response

import com.google.gson.annotations.SerializedName

data class EmployeeRespose(

	@field:SerializedName("data")
	val datas: List<DatasItem>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DatasItem(

	@field:SerializedName("profile_image")
	val profileImage: String? = null,

	@field:SerializedName("employee_name")
	val employeeName: String? = null,

	@field:SerializedName("employee_salary")
	val employeeSalary: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("employee_age")
	val employeeAge: String? = null
)
