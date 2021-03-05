package com.jeanbarrossilva.andre.extension

import android.view.Window
import androidx.core.view.WindowInsetsControllerCompat
import com.jeanbarrossilva.andre.extension.ContextX.isSystemInLightTheme
import com.jeanbarrossilva.andre.extension.ContextX.navigationBarColor
import com.jeanbarrossilva.andre.extension.ContextX.statusBarColor

object WindowX {
    val Window.insetsControllerCompat get() = WindowInsetsControllerCompat(this, decorView)
    
    fun Window.enableDefaultAppearance() {
        statusBarColor = context.statusBarColor
        navigationBarColor = context.navigationBarColor
        insetsControllerCompat.isAppearanceLightStatusBars = context.isSystemInLightTheme
        insetsControllerCompat.isAppearanceLightNavigationBars = context.isSystemInLightTheme
    }
}