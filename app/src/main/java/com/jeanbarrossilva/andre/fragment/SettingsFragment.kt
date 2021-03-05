package com.jeanbarrossilva.andre.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.viewmodel.SettingsViewModel
import com.jeanbarrossilva.andre.viewmodel.factory.AndreViewModelFactory.Companion.factoryOf

class SettingsFragment : PreferenceFragmentCompat() {
    private val viewModel by viewModels<SettingsViewModel> { factoryOf<SettingsViewModel>(this) }
    
    override fun onStart() {
        super.onStart()
        viewModel.hideMenu()
        viewModel.hideFab()
    }
    
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
    
    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        viewModel.onClick(preference)
        return super.onPreferenceTreeClick(preference)
    }
}