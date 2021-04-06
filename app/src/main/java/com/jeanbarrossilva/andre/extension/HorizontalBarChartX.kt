package com.jeanbarrossilva.andre.extension

import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet

object HorizontalBarChartX {
	fun HorizontalBarChart.setEmptyData() {
		data = BarData(BarDataSet(mutableListOf(), ""))
	}
}