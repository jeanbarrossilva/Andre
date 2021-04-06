package com.jeanbarrossilva.andre.interop.implementation

import android.content.Context
import android.graphics.Color
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.MPPointF
import com.jeanbarrossilva.andre.extension.ChartX.setOnChartValueSelectedListener
import com.jeanbarrossilva.andre.extension.PieChartX.setEmptyData
import com.jeanbarrossilva.andre.extension.PieEntryX.toAndreChartEntry
import com.jeanbarrossilva.andre.interop.AndreChart
import com.jeanbarrossilva.andre.interop.AndreChartEntry

class AndrePieChart(context: Context): AndreChart<PieEntry, PieChart> {
	override val view =
		PieChart(context).apply {
			setEmptyData()
			data.dataSet.colors.clear()
			data.dataSet.iconsOffset = MPPointF(-20f, 0f)
			legend?.isEnabled = false
			description?.isEnabled = false
			isDrawHoleEnabled = false
			invalidate()
		}
	override var entries = super.entries
		set(value) {
			field = value
			view.data.dataSet.clear()
			value.forEach { entry -> view.data.dataSet.addEntry(entry.original) }
		}
	
	override fun setShowEntryLabels(showsEntryLabels: Boolean) =
		view.setDrawEntryLabels(showsEntryLabels)
	
	override fun setShowEntryValues(showsEntryValues: Boolean) {
		view.data.dataSet.valueTextColor = if (showsEntryValues) Color.WHITE else Color.TRANSPARENT
	}
	
	override fun add(entry: AndreChartEntry<PieEntry>) {
		view.data.dataSet.colors.add(entry.color)
		view.data.dataSet.addEntry(entry.original)
	}
	
	override fun setOnSelectEntryListener(listener: AndreChart.OnSelectEntryListener<PieEntry>) {
		view.setOnChartValueSelectedListener { entry, _ ->
			val andreChartEntry = (entry as PieEntry).toAndreChartEntry(view.data.dataSet)
			listener.onSelectEntry(andreChartEntry)
		}
	}
}