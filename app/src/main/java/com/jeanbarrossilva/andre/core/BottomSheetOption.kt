package com.jeanbarrossilva.andre.core

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

data class BottomSheetOption(
	val icon: Drawable,
	val title: String,
	val action: () -> Unit,
	val dismissesDialog: Boolean = true
) {
	constructor(
		context: Context?,
		@DrawableRes iconRes: Int,
		@StringRes titleRes: Int,
		action: () -> Unit,
		dismissesDialog: Boolean = true
	): this(
		ContextCompat.getDrawable(context!!, iconRes)!!,
		context.getString(titleRes),
		action,
		dismissesDialog
	)
}