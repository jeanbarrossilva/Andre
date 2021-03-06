package com.jeanbarrossilva.andre.viewmodel

import androidx.core.view.WindowInsetsCompat.Type.ime
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.core.FieldRuler.Companion.areRulesFollowed
import com.jeanbarrossilva.andre.core.FieldRuler.Companion.scream
import com.jeanbarrossilva.andre.core.database.area.Area
import com.jeanbarrossilva.andre.extension.EditTextX.doOnTextChanged
import com.jeanbarrossilva.andre.extension.EditTextX.focusWithInput
import com.jeanbarrossilva.andre.extension.FragmentX.withFab
import com.jeanbarrossilva.andre.extension.TextInputLayoutX.field
import com.jeanbarrossilva.andre.extension.WindowX.insetsControllerCompat
import com.jeanbarrossilva.andre.fragment.AreaComposerFragment
import com.jeanbarrossilva.andre.model.AreaComposerModel
import com.jeanbarrossilva.andre.repository.AreaRepository
import kotlinx.coroutines.launch

class AreaComposerViewModel(private val fragment: AreaComposerFragment): ViewModel() {
	private val fieldRulers =
		with(fragment.binding) {
			AreaComposerModel.getFieldRulers(nameFieldLayout, attentionLevelFieldLayout)
		}
	
	private var icon = Area.DEFAULT_ICON_RES
	private var name = ""
	private var description = ""
	private var attentionLevel = 0
	
	private fun canCompose() = fieldRulers.areRulesFollowed
	
	private fun compose() {
		val area = Area(icon, name, description, color = 0x00000000, attentionLevel)
		AreaRepository.scope.launch { AreaRepository.addAsync(area).await() }
	}
	
	fun configFab() =
		fragment.withFab {
			setImageResource(R.drawable.ic_done)
			setOnClickListener {
				if (canCompose()) {
					compose()
					fragment.findNavController().popBackStack()
				} else
					fieldRulers.scream()
			}
		}
	
	fun focusPrimaryField() {
		fragment.binding.nameFieldLayout.editText?.focusWithInput()
	}
	
	fun listenFields() =
		with(fragment.binding) {
			nameFieldLayout.field.doOnTextChanged { text -> name = text }
			descriptionFieldLayout.field.doOnTextChanged { text -> description = text }
			attentionLevelFieldLayout.field.doOnTextChanged { text ->
				attentionLevel = text.toInt()
			}
		}
	
	fun hideSoftInput() {
		fragment.activity?.window?.insetsControllerCompat?.hide(ime())
	}
}