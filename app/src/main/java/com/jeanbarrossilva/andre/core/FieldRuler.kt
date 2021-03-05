package com.jeanbarrossilva.andre.core

import android.widget.EditText
import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout
import com.jeanbarrossilva.andre.extension.ContextX.toast

class FieldRuler private constructor(private val field: EditText, private val rule: FieldRule) {
	constructor(field: EditText, rule: EditText.() -> FieldRule): this(field, rule(field))
	
	fun complain() {
		when (field.parent) {
			is TextInputLayout -> (field.parent as TextInputLayout).error = rule.complaint
			else -> field.context?.toast(rule.complaint)
		}
	}
	
	@Suppress("FunctionName")
	companion object {
		val List<FieldRuler>.areRulesFollowed get() = all { it.rule.isFollowed }
		
		fun FilledFieldRuler(field: EditText, @StringRes ruleComplaintRes: Int) =
			FieldRuler(field) { FieldRule(context, text?.isNotBlank() == true, ruleComplaintRes) }
		
		fun List<FieldRuler>.scream() = filterNot { it.rule.isFollowed }.forEach { it.complain() }
	}
}