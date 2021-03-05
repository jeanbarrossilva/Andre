package com.jeanbarrossilva.andre.extension

import android.content.Context
import android.content.SharedPreferences
import com.jeanbarrossilva.andre.R

object SharedPreferencesX {
	private fun <T> SharedPreferences.onPreferenceChange(
		key: String,
		value: SharedPreferences.(key: String) -> T,
		block: (T) -> Unit
	) {
		block(value(this, key))
		registerOnSharedPreferenceChangeListener { preferences, changedPreferenceKey ->
			if (changedPreferenceKey == key)
				block(value(preferences, key))
		}
	}
	
	fun SharedPreferences.onToggleShowsPercentage(context: Context, block: (Boolean) -> Unit) =
		onPreferenceChange(
			key = context.getString(R.string.settings_key_show_percentage),
			value = { getBoolean(it, false) },
			block
		)
}