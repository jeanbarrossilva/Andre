package com.jeanbarrossilva.andre.extension

import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.data.ChartData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.interfaces.datasets.IDataSet

object ChartX {
	fun <E: Entry, DS: IDataSet<E>, CD: ChartData<DS>> Chart<CD>.setExtraOffsets(size: Float) =
		setExtraOffsets(size, size, size, size)
}