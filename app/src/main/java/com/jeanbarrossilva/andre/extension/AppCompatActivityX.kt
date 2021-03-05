package com.jeanbarrossilva.andre.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController

object AppCompatActivityX {
	val AppCompatActivity.currentFragment
		get() =
			with(supportFragmentManager) {
				primaryNavigationFragment?.childFragmentManager?.fragments?.lastOrNull()
					?: fragments.lastOrNull()
			}
	
	fun AppCompatActivity.findNavController() = currentFragment?.findNavController()
}