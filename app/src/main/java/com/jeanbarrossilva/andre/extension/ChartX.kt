package com.jeanbarrossilva.andre.extension

import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.data.ChartData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

object ChartX {
	fun <E: Entry, DS: IDataSet<E>, CD: ChartData<DS>> Chart<CD>.setExtraOffsets(size: Float) =
		setExtraOffsets(size, size, size, size)
	
	fun <E: Entry, DS: IDataSet<E>, CD: ChartData<DS>> Chart<CD>.setOnChartValueSelectedListener(
		listener: (Entry?, Highlight?) -> Unit
	) {
		@Suppress("LocalVariableName")
		val _listener =
			object: OnChartValueSelectedListener {
				override fun onValueSelected(e: Entry?, h: Highlight?) = listener(e, h)
				
				override fun onNothingSelected() {
				}
			}
		setOnChartValueSelectedListener(_listener)
	}
}