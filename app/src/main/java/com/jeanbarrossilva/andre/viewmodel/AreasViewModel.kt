package com.jeanbarrossilva.andre.viewmodel

import android.view.Menu
import android.view.MenuInflater
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.adapter.AreaListItemAdapter
import com.jeanbarrossilva.andre.core.database.area.Area
import com.jeanbarrossilva.andre.extension.ContextX.preferences
import com.jeanbarrossilva.andre.extension.FragmentX.withFab
import com.jeanbarrossilva.andre.extension.MenuInflaterX.inflate
import com.jeanbarrossilva.andre.extension.NavControllerX.navigateAnimating
import com.jeanbarrossilva.andre.extension.NavControllerX.navigateOnceFrom
import com.jeanbarrossilva.andre.extension.SharedPreferencesX.onToggleShowsPercentage
import com.jeanbarrossilva.andre.extension.WindowX.enableDefaultAppearance
import com.jeanbarrossilva.andre.fragment.AreasFragment
import com.jeanbarrossilva.andre.fragment.AreasFragmentDirections
import com.jeanbarrossilva.andre.repository.AreaRepository
import kotlinx.coroutines.launch

class AreasViewModel(private val fragment: AreasFragment): ViewModel() {
    private suspend fun areas() = AreaRepository.getAreasAsync().await()
    
    private fun navigateToDetailsOf(area: Area) =
        fragment.findNavController().navigateOnceFrom(
            R.id.areasFragment to AreasFragmentDirections.toDetailsOf(area)
        )
    
    fun configSystemBars() {
        fragment.activity?.window?.enableDefaultAppearance()
    }
    
    fun showMenu() = fragment.setHasOptionsMenu(true)
    
    fun configMenu(menu: Menu, inflater: MenuInflater) =
        inflater.inflate(menu, R.menu.menu_areas) { item ->
            when (item.itemId) {
                R.id.toolbar_settings ->
                    fragment.findNavController().navigateAnimating(R.id.settingsFragment)
            }
        }
    
    fun configFab() =
        fragment.withFab {
            show()
            setImageResource(R.drawable.ic_add)
            setOnClickListener {
                fragment.findNavController().navigateOnceFrom(R.id.areasFragment to R.id.compose)
            }
        }

    fun showAreas() =
        with(fragment.binding.areasRecyclerView) {
            AreaRepository.scope.launch {
                areas().let { areas ->
                    fragment.activity?.runOnUiThread {
                        areas.observe(fragment) {
                            layoutManager = LinearLayoutManager(context)
                            context.preferences.onToggleShowsPercentage(context) { showsPercentage ->
                                adapter =
                                    AreaListItemAdapter(
                                        it,
                                        showsPercentage,
                                        onAreaClick = { area -> navigateToDetailsOf(area) },
                                        onAreaHold = { }
                                    )
                            }
                        }
                    }
                }
            }
        }
}