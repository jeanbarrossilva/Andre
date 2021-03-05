package com.jeanbarrossilva.andre.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.extension.ActivityX.composeEmail
import com.jeanbarrossilva.andre.extension.FragmentX.withFab
import com.jeanbarrossilva.andre.fragment.SettingsFragment

class SettingsViewModel(private val fragment: SettingsFragment): ViewModel() {
	fun hideMenu() = fragment.setHasOptionsMenu(false)
	
	fun hideFab() = fragment.withFab { hide() }
	
	fun onClick(preference: Preference?) {
		when (preference?.key) {
			fragment.context?.getString(R.string.settings_key_generosity_box) ->
				fragment.findNavController().navigate(R.id.be_generous)
			fragment.context?.getString(R.string.settings_key_send_feedback) ->
				fragment.activity?.composeEmail(
					receiver = "jeanbarrossilva@outlook.com",
					subject = "Vita Feedback"
				)
		}
	}
}