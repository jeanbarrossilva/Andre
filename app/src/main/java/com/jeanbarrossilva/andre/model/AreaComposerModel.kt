package com.jeanbarrossilva.andre.model

import com.google.android.material.textfield.TextInputLayout
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.core.FieldRuler.Companion.FilledFieldRuler

object AreaComposerModel {
	fun getFieldRulers(
		nameFieldLayout: TextInputLayout,
		attentionLevelFieldLayout: TextInputLayout
	) = listOf(
		FilledFieldRuler({ nameFieldLayout }, R.string.AreaComposerFragment_complaint_name),
		FilledFieldRuler(
			{ attentionLevelFieldLayout },
			R.string.AreaComposerFragment_complaint_attention_level
		)
	)
}