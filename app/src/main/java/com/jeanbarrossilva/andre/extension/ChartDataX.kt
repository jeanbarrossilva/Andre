package com.jeanbarrossilva.andre.extension

import com.github.mikephil.charting.data.ChartData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.interfaces.datasets.IDataSet

object ChartDataX {
	val <E: Entry, DS: IDataSet<E>> ChartData<DS>.dataSet: DS get() = dataSets.first()
}