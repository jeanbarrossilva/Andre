package com.jeanbarrossilva.andre.core

import android.widget.EditText
import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout
import com.jeanbarrossilva.andre.extension.TextInputLayoutX.field

class FieldRuler(
	private val layout: () -> TextInputLayout,
	private val rule: EditText.() -> FieldRule
) {
	private fun field() = layout().field
	
	private fun rule() = rule(field())
	
	fun complain() {
		layout().error = rule(field()).complaint
	}
	
	@Suppress("FunctionName")
	companion object {
		val List<FieldRuler>.areRulesFollowed get() = all { it.rule().isFollowed }
		
		fun FilledFieldRuler(layout: () -> TextInputLayout, @StringRes ruleComplaintRes: Int) =
			FieldRuler(layout) { FieldRule(context, text?.isNotBlank() == true, ruleComplaintRes) }
		
		fun List<FieldRuler>.scream() = filterNot { it.rule().isFollowed }.forEach { it.complain() }
	}
}