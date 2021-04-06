package com.jeanbarrossilva.andre.extension

import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet
import com.jeanbarrossilva.andre.interop.implementation.AndrePieEntry

object PieEntryX {
	fun PieEntry.toAndreChartEntry(dataSet: IPieDataSet): AndrePieEntry {
		val color = dataSet.colors[dataSet.getEntryIndex(this)]!!
		return AndrePieEntry(label, icon, value, color, dataSet)
	}
}