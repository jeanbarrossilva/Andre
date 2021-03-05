package com.jeanbarrossilva.andre.core

import android.content.Context
import androidx.annotation.StringRes

class FieldRule(value: Boolean, val complaint: String) {
	constructor(context: Context, value: Boolean, @StringRes complaintRes: Int):
		this(value, context.getString(complaintRes))
	
	val isFollowed = value
}