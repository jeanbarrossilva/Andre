package com.jeanbarrossilva.andre.extension

import android.content.res.ColorStateList
import androidx.annotation.ColorInt
import com.google.android.material.button.MaterialButton

object MaterialButtonX {
    fun MaterialButton.setTint(@ColorInt color: Int) {
        iconTint = ColorStateList.valueOf(color)
        setTextColor(color)
    }
}