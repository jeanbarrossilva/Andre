package com.jeanbarrossilva.andre.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeanbarrossilva.andre.BuildConfig
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.core.Area
import com.jeanbarrossilva.andre.core.SubareaIndicator
import com.jeanbarrossilva.andre.extension.NavControllerX.navigateOnce
import com.jeanbarrossilva.andre.fragment.AreasFragment
import com.jeanbarrossilva.andre.fragment.AreasFragmentDirections
import com.jeanbarrossilva.andre.ui.adapter.AreaAdapter

class AreasViewModel(private val fragment: AreasFragment): ViewModel() {
	private val areas = Area.values(fragment.context)
	
	private fun configSubareaIndicatorsForDebugging() {
		if (BuildConfig.DEBUG)
			areas.forEach { area ->
				area.subareas.forEach { subarea ->
					subarea.indicator = SubareaIndicator.values(fragment.context).random()
				}
			}
	}
	
	fun showAreas() {
		fragment.binding.areasView.adapter =
			AreaAdapter(
				areas,
				onLongClick = {
					val directions = AreasFragmentDirections.showOptionsOf(it)
					fragment.findNavController().navigateOnce(
						forbiddenDestinationId = R.id.areaOptionsBottomSheetFragment,
						directions
					)
				}
			)
		fragment.binding.areasView.layoutManager = LinearLayoutManager(fragment.context)
	}
	
	init {
		configSubareaIndicatorsForDebugging()
	}
}