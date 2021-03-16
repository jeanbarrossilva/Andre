package com.jeanbarrossilva.andre.viewmodel

import android.content.res.ColorStateList
import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.andre.fragment.SubareaDetailsFragment

class SubareaDetailsViewModel(private val fragment: SubareaDetailsFragment): ViewModel() {
	private val subarea = fragment.subarea
	
	fun showDetails() {
		fragment.binding.titleView.text = subarea.title
		fragment.binding.indicatorView.setText(subarea.indicator.titleRes)
		fragment.binding.iconView.setImageResource(subarea.iconRes)
		fragment.binding.iconView.imageTintList = ColorStateList.valueOf(subarea.color)
	}
}