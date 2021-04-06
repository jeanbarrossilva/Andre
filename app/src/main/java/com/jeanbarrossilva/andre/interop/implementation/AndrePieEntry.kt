package com.jeanbarrossilva.andre.interop.implementation

import android.graphics.drawable.Drawable
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet
import com.jeanbarrossilva.andre.interop.AndreChartEntry

data class AndrePieEntry(
	override val title: String,
	override val icon: Drawable,
	override val value: Float,
	override val color: Int,
	private val dataSet: IPieDataSet
): AndreChartEntry<PieEntry> {
	override val original = PieEntry(value, title, icon).also { addColorOf(it) }
	
	private fun addColorOf(entry: PieEntry) {
		val index = dataSet.getEntryIndex(entry)
		val hasEntryColorBeenAdded = dataSet.colors.getOrNull(index) == color
		
		if (!hasEntryColorBeenAdded) {
			val colorIndex = if (index == -1) 0 else index
			dataSet.colors.add(colorIndex, color)
		}
	}
	
	/*
	 * This is kind of a hack. As it isn't possible to override methods from Any in AndreChartEntry
	 * because it is an interface and this is, for now, the only class that extends it, we're doing
	 * it here.
	 */
	override fun equals(other: Any?) = other is AndrePieEntry && other.id == this.id
}