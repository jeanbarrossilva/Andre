package com.jeanbarrossilva.andre.model

import android.widget.EditText
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.core.FieldRuler.Companion.FilledFieldRuler

object AreaComposerModel {
	fun getFieldRulers(nameField: EditText, attentionLevelField: EditText) =
		listOf(
			FilledFieldRuler(nameField, R.string.AreaComposerFragment_complaint_name),
			FilledFieldRuler(
				attentionLevelField,
				R.string.AreaComposerFragment_complaint_attention_level
			)
		)
}