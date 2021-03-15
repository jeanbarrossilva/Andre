package com.jeanbarrossilva.andre.viewmodel

import android.graphics.Color
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.jeanbarrossilva.andre.BuildConfig
import com.jeanbarrossilva.andre.core.SubareaIndicator
import com.jeanbarrossilva.andre.fragment.SubareasFragment

class SubareasViewModel(private val fragment: SubareasFragment): ViewModel() {
	private val area = fragment.area
	private val subareas = area.subareas
	
	fun configSubareasForDebugging() {
		if (BuildConfig.DEBUG) {
			subareas.forEach { subarea -> subarea.indicator = SubareaIndicator.Satisfied }
			Log.d("SubareasViewModel.configSubareasForDebugging", "Configured subareas: $subareas")
		}
	}
	
	fun showSubareasInChart() {
		val entries =
			subareas.map { subarea ->
				PieEntry(
					subarea.indicator.levelAsPercentage(),
					subarea.title,
					ContextCompat.getDrawable(fragment.requireContext(), subarea.iconRes)
				).apply { icon?.setTint(Color.WHITE) }
			}
		val set =
			PieDataSet(entries, "Subareas of ${area.title}").apply {
				colors = subareas.map { subarea -> subarea.color }
			}
		
		with(fragment.binding.subareasChart) {
			data = PieData(set)
			legend?.isEnabled = false
			description?.isEnabled = false
			isDrawHoleEnabled = false
			setDrawEntryLabels(false)
			invalidate()
		}
	}
}