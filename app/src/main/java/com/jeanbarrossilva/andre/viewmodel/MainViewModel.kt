package com.jeanbarrossilva.andre.viewmodel

import android.graphics.Color
import android.view.MenuItem
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.utils.MDUtil.isLandscape
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.activity.MainActivity
import com.jeanbarrossilva.andre.core.Area
import com.jeanbarrossilva.andre.extension.AppCompatActivityX.currentFragment
import com.jeanbarrossilva.andre.extension.BottomNavigationViewX.setupWithAreas
import com.jeanbarrossilva.andre.extension.ContextX.isSystemInDarkTheme
import com.jeanbarrossilva.andre.extension.WindowX.insetsControllerCompat
import com.jeanbarrossilva.andre.fragment.BlankFragmentDirections

@Suppress("StaticFieldLeak")
class MainViewModel(private val activity: MainActivity): ViewModel() {
	private val navController = activity.currentFragment?.findNavController()
	
	private fun navigateToSubareasOf(area: Area) {
		if (navController?.currentDestination?.id != R.id.blankFragment)
			navController?.navigate(R.id.blankFragment)
		navController?.navigate(BlankFragmentDirections.toSubareasOf(area))
	}
	
	fun configBottomNavigation() {
		val areas = Area.values(activity)
		activity.binding.bottomNavigation.setupWithAreas(areas, onSelectArea = {
			navigateToSubareasOf(it)
		})
	}
	
	fun onSelect(item: MenuItem) {
		if (item.itemId == android.R.id.home)
			activity.onBackPressed()
	}
	
	fun changeNavBarColorForOrientation() {
		activity.window?.navigationBarColor =
			if (activity.isLandscape()) Color.BLACK else activity.getColor(R.color.navigationBar)
		activity.window?.insetsControllerCompat?.isAppearanceLightNavigationBars =
			!activity.isLandscape() && !activity.isSystemInDarkTheme
	}
}