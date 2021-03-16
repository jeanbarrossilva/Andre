package com.jeanbarrossilva.andre.extension

import android.view.Window
import androidx.core.view.WindowInsetsControllerCompat

object WindowX {
    val Window.insetsControllerCompat get() = WindowInsetsControllerCompat(this, decorView)
}