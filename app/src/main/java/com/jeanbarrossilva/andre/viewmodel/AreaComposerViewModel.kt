package com.jeanbarrossilva.andre.viewmodel

import androidx.core.view.WindowInsetsCompat.Type.ime
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.extension.EditTextX.focusWithInput
import com.jeanbarrossilva.andre.extension.FragmentX.withFab
import com.jeanbarrossilva.andre.extension.WindowX.insetsControllerCompat
import com.jeanbarrossilva.andre.fragment.AreaComposerFragment

class AreaComposerViewModel(private val fragment: AreaComposerFragment): ViewModel() {
	fun focusPrimaryField() {
		fragment.binding.nameFieldLayout.editText?.focusWithInput()
	}
	
	fun configFab() =
		fragment.withFab {
			setImageResource(R.drawable.ic_done)
			setOnClickListener {
				// TODO: Save composed area before popping the back stack.
				fragment.findNavController().popBackStack()
			}
		}
	
	fun hideSoftInput() {
		fragment.activity?.window?.insetsControllerCompat?.hide(ime())
	}
}