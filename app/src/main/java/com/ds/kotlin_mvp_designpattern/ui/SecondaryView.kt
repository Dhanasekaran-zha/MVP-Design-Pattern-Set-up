package com.ds.kotlin_mvp_designpattern.ui

import com.ds.kotlin_mvp_designpattern.base.LoadDataView
import com.ds.kotlin_mvp_designpattern.data.response.DatasItem

interface SecondaryView : LoadDataView {
    fun employeeList(list: List<DatasItem>)
}